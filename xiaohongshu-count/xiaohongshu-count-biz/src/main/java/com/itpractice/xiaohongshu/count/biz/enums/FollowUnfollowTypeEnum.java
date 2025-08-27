package com.itpractice.xiaohongshu.count.biz.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * @author cyb
 *
 * 关注/取消关注
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

    public static FollowUnfollowTypeEnum valueOf(Integer code) {
        for (FollowUnfollowTypeEnum followUnfollowTypeEnum : FollowUnfollowTypeEnum.values()) {
            if (Objects.equals(code, followUnfollowTypeEnum.getCode())) {
                return followUnfollowTypeEnum;
            }
        }
        return null;
    }

}