package com.itpractice.xiaohongshu.note.biz.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author cyb
 *
 * 笔记操作枚举
 */
@Getter
@AllArgsConstructor
public enum NoteOperateEnum {

    // 笔记发布
    PUBLISH(1),
    // 笔记删除
    DELETE(0),
    ;

    private final Integer code;
}
