package com.itpractice.xiaohongshu.comment.biz.service;

import com.itpractice.framework.common.response.PageResponse;
import com.itpractice.framework.common.response.Response;
import com.itpractice.xiaohongshu.comment.biz.model.vo.FindCommentItemRspVO;
import com.itpractice.xiaohongshu.comment.biz.model.vo.FindCommentPageListReqVO;
import com.itpractice.xiaohongshu.comment.biz.model.vo.PublishCommentReqVO;

public interface CommentService {

    /**
     * 发布评论
     * @param publishCommentReqVO
     * @return
     */
    Response<?> publishComment(PublishCommentReqVO publishCommentReqVO);

    /**
     * 评论列表分页查询
     * @param findCommentPageListReqVO
     * @return
     */
    PageResponse<FindCommentItemRspVO> findCommentPageList(FindCommentPageListReqVO findCommentPageListReqVO);

}
