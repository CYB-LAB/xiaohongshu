package com.itpractice.xiaohongshu.data.align.job;

import cn.hutool.core.collection.CollUtil;
import com.itpractice.xiaohongshu.data.align.domain.dataobject.MqFailedMessageDO;
import com.itpractice.xiaohongshu.data.align.domain.mapper.DeleteMapper;
import com.itpractice.xiaohongshu.data.align.domain.mapper.SelectMapper;
import com.itpractice.xiaohongshu.data.align.domain.mapper.UpdateMapper;
import com.itpractice.xiaohongshu.data.align.enums.MqFaildeMessageStatusEnum;
import com.xxl.job.core.handler.annotation.XxlJob;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * @author cyb
 *
 * MQ失败消息重试定时任务
 */
@Component
@Slf4j
public class MQFailedMessageXxlJob {

    @Resource
    private SelectMapper selectMapper;
    @Resource
    private UpdateMapper updateMapper;
    @Resource
    private DeleteMapper deleteMapper;
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 分片广播任务
     */
    @XxlJob("mqFailedMessageJobHandler")
    public void mqFailedMessageJobHandler() throws Exception {
        log.info("==> 开始执行失败MQ消息重试任务, 时间: {}", LocalDateTime.now());

        LocalDateTime currentTime = LocalDateTime.now();

        // 一批次 1000 条
        int batchSize = 1000;

        for (; ;){
            // 分批次查询 t_mq_failed_message , 如一批次查询 1000 条，直到全部查询完成
            List<MqFailedMessageDO> messages = selectMapper.selectPendingMessages(currentTime, batchSize);

            if (CollUtil.isEmpty(messages)) break;

            log.info("==> 发现 {} 条需要重试的MQ消息", messages.size());

            messages.forEach(message -> {
                try {
                    // 尝试发送消息
                    rocketMQTemplate.syncSend(message.getTopic(), message.getMessageBody());
                    log.info("==> 消息重试成功, id: {}, topic: {}", message.getId(), message.getTopic());

                    MqFailedMessageDO messageDO = MqFailedMessageDO.builder()
                            .id(message.getId())
                            .updateTime(LocalDateTime.now())
                            .status(MqFaildeMessageStatusEnum.SUCCESS.getCode())
                            .build();

                    // 更新消息状态
                    updateMapper.updateRetryInfo(messageDO);
                }catch (Exception e){
                    log.error("==> 消息重试失败, id: {}, topic: {}", message.getId(), message.getTopic(), e);

                    // 检查是否达到最大重试次数
                    if (message.getRetryCount() >= message.getMaxRetryTimes() - 1) {
                        log.warn("==> 消息已达到最大重试次数, 标记为废弃, id: {}", message.getId());

                        MqFailedMessageDO messageDO = MqFailedMessageDO.builder()
                                .id(message.getId())
                                .updateTime(LocalDateTime.now())
                                .status(MqFaildeMessageStatusEnum.FAILED.getCode())
                                .errorMsg(e.getMessage())
                                .build();

                        updateMapper.updateRetryInfo(messageDO);
                    } else {
                        // 计算下次重试时间，使用指数退避策略
                        int nextRetryCount = message.getRetryCount() + 1;
                        long delayMinutes = (long) Math.pow(2, nextRetryCount); // 指数退避
                        LocalDateTime nextRetryTime = LocalDateTime.now().plus(delayMinutes, ChronoUnit.MINUTES);

                        MqFailedMessageDO messageDO = MqFailedMessageDO.builder()
                                .id(message.getId())
                                .updateTime(LocalDateTime.now())
                                .retryCount(nextRetryCount)
                                .nextRetryTime(nextRetryTime)
                                .errorMsg(e.getMessage())
                                .build();

                        updateMapper.updateRetryInfo(messageDO);
                    }
                }
            });
        }

    }


}
