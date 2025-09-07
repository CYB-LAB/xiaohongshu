package com.itpractice.xiaohongshu.comment.biz.domain.dataobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDO {
    private Long id;

    private String content;

    private String avatar;

    private String nickname;

    private String mail;

    private String website;

    private String routerUrl;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Boolean isDeleted;

    private Long replyCommentId;

    private Long parentCommentId;

    private String reason;

    private Integer status;

    private Integer level;

    private Long parentId;

    private Long userId;

    private Long childCommentTotal;

    private Long likeTotal;

    private Long replyTotal;

    private String contentUuid;

    private Boolean isContentEmpty;

    private String imageUrl;

    private Boolean isTop;

    private Long noteId;

    private Long replyUserId;

}