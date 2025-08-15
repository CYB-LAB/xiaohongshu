package com.itpractice.xiaohongshu.user.biz.service;

import com.itpractice.framework.common.utils.Response;
import com.itpractice.xiaohongshu.user.biz.model.vo.UpdateUserInfoReqVO;

/**
 * @author cyb
 *
 * 用户服务
 */
public interface UserService {

    /**
     * 更新用户信息
     *
     * @param updateUserInfoReqVO
     * @return
     */
    Response<?> updateUserInfo(UpdateUserInfoReqVO updateUserInfoReqVO);
}
