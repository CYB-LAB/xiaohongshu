package com.itpractice.xiaohongshu.auth.controller;

import com.itpractice.framework.biz.operationlog.aspect.ApiOperationLog;
import com.itpractice.framework.common.utils.Response;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * @author cyb
 * <p>
 * 测试用
 */

@RestController
public class TestController {

    @GetMapping("/test")
    @ApiOperationLog(description = "测试接口1")
    public Response<String> test() {
        return Response.success("测试用");
    }

    @PostMapping("/test2")
    @ApiOperationLog(description = "测试接口2")
    public Response<User> test2(@RequestBody @Validated User user) {
        int i = 1 / 0;

        return Response.success(user);
    }
}
