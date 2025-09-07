package com.itpractice.xiaohongshu.kv.biz.service;

import com.itpractice.framework.common.response.Response;
import com.itpractice.xiaohongshu.kv.dto.req.BatchAddCommentContentReqDTO;
import com.itpractice.xiaohongshu.kv.dto.req.BatchFindCommentContentReqDTO;

/**
 * @author cyb
 *
 * 评论内容服务
 */
public interface CommentContentService {

    /**
     * 批量添加评论内容
     * @param batchAddCommentContentReqDTO
     * @return
     */
    Response<?> batchAddCommentContent(BatchAddCommentContentReqDTO batchAddCommentContentReqDTO);

    /**
     * 批量查询评论内容
     * @param batchFindCommentContentReqDTO
     * @return
     */
    Response<?> batchFindCommentContent(BatchFindCommentContentReqDTO batchFindCommentContentReqDTO);

}
