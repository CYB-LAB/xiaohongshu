package com.itpractice.xiaohongshu.count.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cyb
 *
 * 查询用户统计信息返回结果  出参
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindUserCountsByIdRspDTO {

    /**
     * 用户 ID
     */
    private Long userId;

    /**
     * 粉丝数
     */
    private Long fansTotal;

    /**
     * 关注数
     */
    private Long followingTotal;

    /**
     * 当前发布笔记数
     */
    private Long noteTotal;

    /**
     * 当前获得点赞数
     */
    private Long likeTotal;

    /**
     * 当前获得收藏数
     */
    private Long collectTotal;
}
