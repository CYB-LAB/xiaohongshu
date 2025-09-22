package com.itpractice.xiaohongshu.comment.biz.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author cyb
 *
 * 评论点赞、取消点赞 Type
 */
@Getter
@AllArgsConstructor
public enum LikeUnlikeCommentTypeEnum {

    // 点赞
    LIKE(1),
    // 取消点赞
    UNLIKE(0),
    ;

    private final Integer code;
}
