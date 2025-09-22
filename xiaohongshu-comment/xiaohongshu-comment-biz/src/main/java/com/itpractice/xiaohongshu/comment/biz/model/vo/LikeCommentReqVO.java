package com.itpractice.xiaohongshu.comment.biz.model.vo;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cyb
 *
 * 点赞评论请求参数  入参
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LikeCommentReqVO {

    @NotNull(message = "评论 ID 不能为空")
    private Long commentId;
}
