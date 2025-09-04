package com.itpractice.xiaohongshu.comment.biz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.itpractice.xiaohongshu.comment.biz.domain.mapper")
public class XiaohongshuCommentBizApplication {
    public static void main(String[] args) {
        SpringApplication.run(XiaohongshuCommentBizApplication.class, args);
    }
}
