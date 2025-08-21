package com.itpractice.xiaohongshu.user.relation.biz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.itpractice.xiaohongshu.user.relation.biz.domain.mapper")
@EnableFeignClients(basePackages = "com.itpractice.xiaohongshu")
public class XiaohongshuUserRelationBizApplication {
    public static void main(String[] args) {
        SpringApplication.run(XiaohongshuUserRelationBizApplication.class, args);
    }
}
