package com.itpractice.xiaohongshu.user.relation.biz.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author cyb
 *
 * 关注/取关类型枚举
 */

@Getter
@AllArgsConstructor
public enum FollowUnfollowTypeEnum {

    // 关注
    FOLLOW(1),
    // 取关
    UNFOLLOW(0),
    ;

    private final Integer code;
}
