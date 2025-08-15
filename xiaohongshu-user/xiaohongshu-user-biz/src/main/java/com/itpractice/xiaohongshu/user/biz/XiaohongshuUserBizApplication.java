package com.itpractice.xiaohongshu.user.biz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.itpractice.xiaohongshu.user.biz.domain.mapper")
@EnableFeignClients(basePackages = "com.itpractice.xiaohongshu")
public class XiaohongshuUserBizApplication {
    public static void main(String[] args) {
        SpringApplication.run(XiaohongshuUserBizApplication.class, args);
    }
}
