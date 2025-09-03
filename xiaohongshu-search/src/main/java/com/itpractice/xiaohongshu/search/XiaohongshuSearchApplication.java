package com.itpractice.xiaohongshu.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class XiaohongshuSearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(XiaohongshuSearchApplication.class, args);
    }
}
