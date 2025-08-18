package com.itpractice.xiaohongshu.note.biz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.itpractice.xiaohongshu.note.biz.domain.mapper")
public class XiaohongshuNoteBizApplication {
    public static void main(String[] args) {
        SpringApplication.run(XiaohongshuNoteBizApplication.class, args);
    }
}
