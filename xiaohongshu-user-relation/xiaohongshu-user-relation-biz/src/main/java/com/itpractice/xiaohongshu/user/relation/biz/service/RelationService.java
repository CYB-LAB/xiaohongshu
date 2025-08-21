package com.itpractice.xiaohongshu.user.relation.biz.service;

import com.itpractice.xiaohongshu.user.relation.biz.mode.vo.FollowUserReqVO;
import com.itpractice.framework.common.utils.Response;

/**
 * @author cyb
 *
 * 关注业务
 */
public interface RelationService {

    /**
     * 关注用户
     * @param followUserReqVO
     * @return
     */
    Response<?> follow(FollowUserReqVO followUserReqVO);
}
