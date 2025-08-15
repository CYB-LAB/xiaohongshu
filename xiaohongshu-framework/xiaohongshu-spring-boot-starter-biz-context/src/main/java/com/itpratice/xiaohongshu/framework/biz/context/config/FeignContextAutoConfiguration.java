package com.itpratice.xiaohongshu.framework.biz.context.config;

import com.itpratice.xiaohongshu.framework.biz.context.interceptor.FeignRequestInterceptor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author cyb
 *
 * Feign 请求拦截器自动配置
 */
@AutoConfiguration
public class FeignContextAutoConfiguration {

    @Bean
    public FeignRequestInterceptor feignRequestInterceptor() {
        return new FeignRequestInterceptor();
    }
}
