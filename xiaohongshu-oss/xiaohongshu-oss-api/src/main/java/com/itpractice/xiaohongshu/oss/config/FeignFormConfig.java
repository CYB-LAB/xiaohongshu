package com.itpractice.xiaohongshu.oss.config;


import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cyb
 *
 * Feign 配置
 */
@Configuration
public class FeignFormConfig {

    @Bean
    public Encoder feignFormEncoder() {
        return new SpringFormEncoder();
    }
}
