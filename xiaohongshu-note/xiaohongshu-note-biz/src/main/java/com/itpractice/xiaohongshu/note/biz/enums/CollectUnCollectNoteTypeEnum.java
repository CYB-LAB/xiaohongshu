package com.itpractice.xiaohongshu.note.biz.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author cyb
 *
 * 收藏/取消收藏笔记枚举
 */

@Getter
@AllArgsConstructor
public enum CollectUnCollectNoteTypeEnum {

    // 收藏
    COLLECT(1),
    // 取消收藏
    UN_COLLECT(0),
    ;

    private final Integer code;
}
