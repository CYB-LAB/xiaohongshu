package com.itpractice.xiaohongshu.count.biz.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.itpractice.framework.biz.operationlog.aspect.ApiOperationLog;
import com.itpractice.framework.common.response.Response;
import com.itpractice.xiaohongshu.count.biz.service.UserCountService;
import com.itpractice.xiaohongshu.count.dto.FindUserCountsByIdReqDTO;
import com.itpractice.xiaohongshu.count.dto.FindUserCountsByIdRspDTO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/count")
@Slf4j
public class UserCountController {

    @Resource
    private UserCountService userCountService;

    @PostMapping(value = "/user/data")
    @ApiOperationLog(description = "获取用户计数数据")
    @SentinelResource("findUserCountData")
    public Response<FindUserCountsByIdRspDTO> findUserCountData(@Validated @RequestBody FindUserCountsByIdReqDTO findUserCountsByIdReqDTO) {
        return userCountService.findUserCountData(findUserCountsByIdReqDTO);
    }
}
