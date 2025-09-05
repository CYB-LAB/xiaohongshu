package com.itpractice.xiaohongshu.comment.biz.retry;

import com.itpractice.xiaohongshu.comment.biz.domain.dataobject.MqFailedMessageDO;
import com.itpractice.xiaohongshu.comment.biz.domain.mapper.MqFailedMessageMapper;
import com.itpractice.xiaohongshu.comment.biz.enums.MqFaildeMessageStatusEnum;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author cyb
 *
 * MQ发送失败重试
 */
@Component
@Slf4j
public class SendMqRetryHelper {

    @Resource
    private RocketMQTemplate rocketMQTemplate;
    @Resource
    private RetryTemplate retryTemplate;
    @Resource(name = "taskExecutor")
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;
    @Resource
    private MqFailedMessageMapper mqFailedMessageMapper;

    /**
     * 异步发送 MQ
     * @param topic
     */
    public void asyncSend(String topic, String body) {
        log.info("==> 开始异步发送 MQ, Topic: {}, Body: {}", topic, body);

        // 构建消息对象，并将 DTO 转成 Json 字符串设置到消息体中
        Message<String> message = MessageBuilder.withPayload(body)
                .build();

        // 异步发送 MQ 消息，提升接口响应速度
        rocketMQTemplate.asyncSend(topic, message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("==> 【评论发布】MQ 发送成功，SendResult: {}", sendResult);
            }

            @Override
            public void onException(Throwable throwable) {
                log.error("==> 【评论发布】MQ 发送异常: ", throwable);
                handleRetry(topic, message);
            }
        });
    }

    /**
     * 重试处理
     * @param topic
     * @param message
     */
    private void handleRetry(String topic, Message<String> message) {
        // 异步处理
        threadPoolTaskExecutor.submit(() -> {
            try {
                // 通过 retryTemplate 执行重试
                retryTemplate.execute((RetryCallback<Void, RuntimeException>) context -> {
                    log.info("==> 开始重试 MQ 发送, 当前重试次数: {}, 时间: {}", context.getRetryCount() + 1, LocalDateTime.now());
                    // 同步发送 MQ
                    rocketMQTemplate.syncSend(topic, message);
                    return null;
                });
            } catch (Exception e) {
                // 多次重试失败，进入兜底方案
                fallback(e, topic, message.getPayload());
            }
        });
    }

    /**
     * 兜底方案: 将发送失败的 MQ 写入数据库，之后，通过定时任务扫表，将发送失败的 MQ 再次发送，最终发送成功后，将该记录物理删除
     */
    private void fallback(Exception e, String topic, String bodyJson) {
        log.error("==> 多次发送失败, 进入兜底方案, Topic: {}, bodyJson: {}", topic, bodyJson, e);

        try {
            MqFailedMessageDO message = MqFailedMessageDO.builder()
                    .topic(topic)
                    .messageBody(bodyJson)
                    .status(MqFaildeMessageStatusEnum.WAIT_RETRY.getCode()) // 待重试
                    .retryCount(0)
                    .maxRetryTimes(5) // 默认最大重试5次
                    .nextRetryTime(LocalDateTime.now().plus(1, ChronoUnit.MINUTES)) // 首次进入兜底方案，1分钟后重试
                    .errorMsg(e.getMessage() != null ? e.getMessage() : e.toString()) // 错误信息
                    .build();

            mqFailedMessageMapper.insert(message);
            log.info("==> 失败消息已写入数据库, id: {}", message.getId());
        } catch (Exception ex) {
            log.error("==> 兜底方案执行失败，消息持久化异常", ex);
            // 此处可考虑更底层的兜底，如写入本地文件
        }
    }
}
