package com.itpractice.xiaohongshu.note.biz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.itpractice.xiaohongshu.note.biz.domain.mapper")
@EnableFeignClients(basePackages = "com.itpractice.xiaohongshu")
public class XiaohongshuNoteBizApplication {
    public static void main(String[] args) {
        SpringApplication.run(XiaohongshuNoteBizApplication.class, args);
    }
}
