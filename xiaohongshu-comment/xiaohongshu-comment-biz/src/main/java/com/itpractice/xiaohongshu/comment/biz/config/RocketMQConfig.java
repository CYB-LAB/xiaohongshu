package com.itpractice.xiaohongshu.comment.biz.config;

import org.apache.rocketmq.spring.autoconfigure.RocketMQAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author cyb
 *
 * RocketMQ 配置类
 */
@Configuration
@Import(RocketMQAutoConfiguration .class)
public class RocketMQConfig {
}
