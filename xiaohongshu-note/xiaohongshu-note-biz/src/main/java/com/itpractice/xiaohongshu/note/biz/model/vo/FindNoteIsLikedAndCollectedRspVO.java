package com.itpractice.xiaohongshu.note.biz.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cyb
 *
 * 查询笔记是否被用户点赞和收藏的返回结果  出参
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindNoteIsLikedAndCollectedRspVO {

    /**
     * 笔记 ID
     */
    private Long noteId;

    /**
     * 是否被当前登录的用户点赞
     */
    private Boolean isLiked;

    /**
     * 是否被当前登录的用户收藏
     */
    private Boolean isCollected;
}
