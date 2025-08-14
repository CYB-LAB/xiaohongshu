package com.itpractice.xiaohongshu.auth.controller;

import com.itpractice.framework.biz.operationlog.aspect.ApiOperationLog;
import com.itpractice.framework.common.utils.Response;
import com.itpractice.xiaohongshu.auth.model.vo.user.UserLoginReqVO;
import com.itpractice.xiaohongshu.auth.service.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    @ApiOperationLog(description = "用户登录/注册")
    public Response<String> loginAndRegister(@Validated @RequestBody UserLoginReqVO userLoginReqVO) {
        return userService.loginAndRegister(userLoginReqVO);
    }

    @PostMapping("/logout")
    @ApiOperationLog(description = "账号登出")
    public Response<?> logout(@RequestHeader("userId") String userId) {
        log.info("用户退出登录，userId: {}", userId);

        // todo 账号退出登录逻辑待实现

        return Response.success();
    }
}
