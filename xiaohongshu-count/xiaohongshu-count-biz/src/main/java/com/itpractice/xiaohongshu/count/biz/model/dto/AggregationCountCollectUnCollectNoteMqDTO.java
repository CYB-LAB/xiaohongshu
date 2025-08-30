package com.itpractice.xiaohongshu.count.biz.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cyb
 *
 * 聚合后计数：收藏、取消收藏笔记
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AggregationCountCollectUnCollectNoteMqDTO {

    /**
     * 笔记发布者 ID
     */
    private Long creatorId;

    /**
     * 笔记 ID
     */
    private Long noteId;

    /**
     * 聚合后的计数
     */
    private Integer count;
}
