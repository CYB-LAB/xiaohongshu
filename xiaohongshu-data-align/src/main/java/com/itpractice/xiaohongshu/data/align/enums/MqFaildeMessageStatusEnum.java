package com.itpractice.xiaohongshu.data.align.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * @author cyb
 *
 * MQ失败消息状态枚举
 */
@Getter
@AllArgsConstructor
public enum MqFaildeMessageStatusEnum {

    // 待重试
    WAIT_RETRY(0),
    // 废弃
    FAILED(1),
    // 成功
    SUCCESS(2),
    ;

    private final Integer code;

    public static MqFaildeMessageStatusEnum valueOf(Integer code) {
        for (MqFaildeMessageStatusEnum mqFaildeMessageStatusEnum : MqFaildeMessageStatusEnum.values()) {
            if (Objects.equals(code, mqFaildeMessageStatusEnum.getCode())) {
                return mqFaildeMessageStatusEnum;
            }
        }
        return null;
    }
}
