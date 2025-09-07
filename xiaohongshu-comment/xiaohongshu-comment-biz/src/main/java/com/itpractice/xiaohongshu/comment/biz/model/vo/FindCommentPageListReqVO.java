package com.itpractice.xiaohongshu.comment.biz.model.vo;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cyb
 *
 * 查询评论列表的请求参数  入参
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindCommentPageListReqVO {

    @NotNull(message = "笔记 ID 不能为空")
    private Long noteId;

    @NotNull(message = "页码不能为空")
    private Integer pageNo = 1;
}
