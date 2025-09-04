package com.itpractice.xiaohongshu.comment.biz.service;

import com.itpractice.framework.common.response.Response;
import com.itpractice.xiaohongshu.comment.biz.model.vo.PublishCommentReqVO;

public interface CommentService {

    /**
     * 发布评论
     * @param publishCommentReqVO
     * @return
     */
    Response<?> publishComment(PublishCommentReqVO publishCommentReqVO);
}
