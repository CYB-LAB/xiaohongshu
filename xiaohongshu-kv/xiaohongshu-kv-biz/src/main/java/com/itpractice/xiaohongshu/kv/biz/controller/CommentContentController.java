package com.itpractice.xiaohongshu.kv.biz.controller;

import com.itpractice.framework.biz.operationlog.aspect.ApiOperationLog;
import com.itpractice.framework.common.response.Response;
import com.itpractice.xiaohongshu.kv.biz.service.CommentContentService;
import com.itpractice.xiaohongshu.kv.dto.req.BatchAddCommentContentReqDTO;
import com.itpractice.xiaohongshu.kv.dto.req.BatchFindCommentContentReqDTO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cyb
 *
 * 评论内容接口
 */
@RestController
@RequestMapping("/kv")
@Slf4j
public class CommentContentController {

    @Resource
    private CommentContentService commentContentService;

    @PostMapping(value = "/comment/content/batchAdd")
    @ApiOperationLog(description = "批量存储评论内容")
    public Response<?> batchAddCommentContent(@Validated @RequestBody BatchAddCommentContentReqDTO batchAddCommentContentReqDTO) {
        return commentContentService.batchAddCommentContent(batchAddCommentContentReqDTO);
    }

    @PostMapping(value = "/comment/content/batchFind")
    @ApiOperationLog(description = "批量查询评论内容")
    public Response<?> batchFindCommentContent(@Validated @RequestBody BatchFindCommentContentReqDTO batchFindCommentContentReqDTO) {
        return commentContentService.batchFindCommentContent(batchFindCommentContentReqDTO);
    }
}
