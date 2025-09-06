package com.itpractice.xiaohongshu.comment.biz.service.impl;


import com.google.common.base.Preconditions;
import com.itpractice.framework.common.response.Response;
import com.itpractice.framework.common.utils.JsonUtils;
import com.itpractice.xiaohongshu.comment.biz.constant.MQConstants;
import com.itpractice.xiaohongshu.comment.biz.model.dto.PublishCommentMqDTO;
import com.itpractice.xiaohongshu.comment.biz.model.vo.PublishCommentReqVO;
import com.itpractice.xiaohongshu.comment.biz.retry.SendMqRetryHelper;
import com.itpractice.xiaohongshu.comment.biz.rpc.DistributedIdGeneratorRpcService;
import com.itpractice.xiaohongshu.comment.biz.service.CommentService;
import com.itpractice.xiaohongshu.framework.biz.context.holder.LoginUserContextHolder;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author cyb
 *
 * 评论服务实现类
 */
@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

    @Resource
    private RocketMQTemplate rocketMQTemplate;
    @Resource
    private SendMqRetryHelper sendMqRetryHelper;
    @Resource
    private DistributedIdGeneratorRpcService distributedIdGeneratorRpcService;

    /**
     * 发布评论
     *
     * @param publishCommentReqVO
     * @return
     */
    @Override
    public Response<?> publishComment(PublishCommentReqVO publishCommentReqVO) {
        // 评论正文
        String content = publishCommentReqVO.getContent();
        // 附近图片
        String imageUrl = publishCommentReqVO.getImageUrl();

        // 评论内容和图片不能同时为空
        Preconditions.checkArgument(StringUtils.isNotBlank(content) || StringUtils.isNotBlank(imageUrl),
                "评论正文和图片不能同时为空");

        // 发布者 ID
        Long creatorId = LoginUserContextHolder.getUserId();

        // RPC: 调用分布式 ID 生成服务，生成评论 ID
        String commentId = distributedIdGeneratorRpcService.generateCommentId();

        // 发送 MQ
        // 构建消息体 DTO
        PublishCommentMqDTO publishCommentMqDTO = PublishCommentMqDTO.builder()
                .noteId(publishCommentReqVO.getNoteId())
                .content(content)
                .imageUrl(imageUrl)
                .replyCommentId(publishCommentReqVO.getReplyCommentId())
                .createTime(LocalDateTime.now())
                .creatorId(creatorId)
                .commentId(Long.valueOf(commentId))
                .build();

        // 发送 MQ (包含重试机制)
        // 发送 MQ (包含重试机制)
        sendMqRetryHelper.asyncSend(MQConstants.TOPIC_PUBLISH_COMMENT, JsonUtils.toJsonString(publishCommentMqDTO));

        return Response.success();
    }
}

