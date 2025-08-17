package com.itpractice.xiaohongshu.user.biz.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author cyb
 *
 * 账号状态枚举
 */

@Getter
@AllArgsConstructor
public enum StatusEnum {
    // 启用
    ENABLE(0),
    // 禁用
    DISABLED(1);

    private final Integer value;
}