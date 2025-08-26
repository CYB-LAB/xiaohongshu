package com.itpractice.xiaohongshu.count.biz.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;
import com.itpractice.xiaohongshu.count.biz.constant.MQConstants;

/**
 * @author cyb
 *
 * 计数：关注数
 */
@Component
@RocketMQMessageListener(consumerGroup = "xiaohongshu_group_" + MQConstants.TOPIC_COUNT_FOLLOWING, // Group 组
        topic = MQConstants.TOPIC_COUNT_FOLLOWING // 主题 Topic
)
@Slf4j
public class CountFollowingConsumer implements RocketMQListener<String> {
    @Override
    public void onMessage(String body) {
        log.info("## 消费到了 MQ 【计数: 关注数】, {}...", body);
    }
}
