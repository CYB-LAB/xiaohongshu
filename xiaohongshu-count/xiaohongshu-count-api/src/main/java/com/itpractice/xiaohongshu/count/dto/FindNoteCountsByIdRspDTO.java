package com.itpractice.xiaohongshu.count.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cyb
 *
 * 查询笔记维度相关计数  出参
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindNoteCountsByIdRspDTO {

    /**
     * 笔记 ID
     */
    private Long noteId;

    /**
     * 点赞数
     */
    private Long likeTotal;

    /**
     * 收藏数
     */
    private Long collectTotal;

    /**
     * 评论数
     */
    private Long commentTotal;
}
