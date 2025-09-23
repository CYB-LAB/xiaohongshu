package com.itpractice.xiaohongshu.count.api;

import com.itpractice.framework.common.response.Response;
import com.itpractice.xiaohongshu.count.constant.ApiConstants;
import com.itpractice.xiaohongshu.count.dto.FindNoteCountsByIdRspDTO;
import com.itpractice.xiaohongshu.count.dto.FindNoteCountsByIdsReqDTO;
import com.itpractice.xiaohongshu.count.dto.FindUserCountsByIdReqDTO;
import com.itpractice.xiaohongshu.count.dto.FindUserCountsByIdRspDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author cyb
 *
 * 计数服务 Feign 接口
 */
@FeignClient(name = ApiConstants.SERVICE_NAME)
public interface CountFeignApi {

    String PREFIX = "/count";

    /**
     * 查询用户计数
     *
     * @param findUserCountsByIdReqDTO
     * @return
     */
    @PostMapping(value = PREFIX + "/user/data")
    Response<FindUserCountsByIdRspDTO> findUserCount(@RequestBody FindUserCountsByIdReqDTO findUserCountsByIdReqDTO);

    /**
     * 批量查询笔记计数
     *
     * @param findNoteCountsByIdsReqDTO
     * @return
     */
    @PostMapping(value = PREFIX + "/notes/data")
    Response<List<FindNoteCountsByIdRspDTO>> findNotesCount(@RequestBody FindNoteCountsByIdsReqDTO findNoteCountsByIdsReqDTO);
}
