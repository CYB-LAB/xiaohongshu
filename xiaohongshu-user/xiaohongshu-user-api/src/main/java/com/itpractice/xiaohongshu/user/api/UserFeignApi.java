package com.itpractice.xiaohongshu.user.api;


import com.itpractice.framework.common.utils.Response;
import com.itpractice.xiaohongshu.user.constant.ApiConstants;
import com.itpractice.xiaohongshu.user.dto.req.FindUserByIdReqDTO;
import com.itpractice.xiaohongshu.user.dto.req.FindUserByPhoneReqDTO;
import com.itpractice.xiaohongshu.user.dto.req.RegisterUserReqDTO;
import com.itpractice.xiaohongshu.user.dto.req.UpdateUserPasswordReqDTO;
import com.itpractice.xiaohongshu.user.dto.resp.FindUserByIdRspDTO;
import com.itpractice.xiaohongshu.user.dto.resp.FindUserByPhoneRspDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = ApiConstants.SERVICE_NAME)
public interface UserFeignApi {

    String PREFIX = "/user";

    /**
     * 用户注册
     *
     * @param registerUserReqDTO
     * @return
     */
    @PostMapping(value = PREFIX + "/register")
    Response<Long> registerUser(@RequestBody RegisterUserReqDTO registerUserReqDTO);

    /**
     * 根据手机号查询用户信息
     *
     * @param findUserByPhoneReqDTO
     * @return
     */
    @PostMapping(value = PREFIX + "/findByPhone")
    Response<FindUserByPhoneRspDTO> findByPhone(@RequestBody FindUserByPhoneReqDTO findUserByPhoneReqDTO);

    /**
     * 更新密码
     *
     * @param updateUserPasswordReqDTO
     * @return
     */
    @PostMapping(value = PREFIX + "/password/update")
    Response<?> updatePassword(@RequestBody UpdateUserPasswordReqDTO updateUserPasswordReqDTO);

    // 省略...

    /**
     * 根据用户 ID 查询用户信息
     *
     * @param findUserByIdReqDTO
     * @return
     */
    @PostMapping(value = PREFIX + "/findById")
    Response<FindUserByIdRspDTO> findById(@RequestBody FindUserByIdReqDTO findUserByIdReqDTO);
}
