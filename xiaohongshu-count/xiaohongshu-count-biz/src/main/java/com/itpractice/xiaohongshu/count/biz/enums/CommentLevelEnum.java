package com.itpractice.xiaohongshu.count.biz.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author cyb
 *
 * 评论等级枚举
 */
@Getter
@AllArgsConstructor
public enum CommentLevelEnum {

    // 一级评论
    ONE(1),
    // 二级评论
    TWO(2),
    ;

    private final Integer code;
}
