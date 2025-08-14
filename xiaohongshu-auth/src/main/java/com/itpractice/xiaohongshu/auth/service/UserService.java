package com.itpractice.xiaohongshu.auth.service;

import com.itpractice.framework.common.utils.Response;
import com.itpractice.xiaohongshu.auth.model.vo.user.UserLoginReqVO;

public interface UserService {
    /**
     * 登录与注册
     * @param userLoginReqVO
     * @return
     */
    Response<String> loginAndRegister(UserLoginReqVO userLoginReqVO);

    /**
     * 退出登录
     * @return
     */
    Response<?> logout(Long userId);
}
