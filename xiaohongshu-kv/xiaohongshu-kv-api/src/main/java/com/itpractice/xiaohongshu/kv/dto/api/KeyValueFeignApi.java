package com.itpractice.xiaohongshu.kv.dto.api;

import com.itpractice.framework.common.response.Response;
import com.itpractice.xiaohongshu.kv.dto.req.AddNoteContentReqDTO;
import com.itpractice.xiaohongshu.kv.dto.req.DeleteNoteContentReqDTO;
import com.itpractice.xiaohongshu.kv.dto.req.FindNoteContentReqDTO;
import com.itpractice.xiaohongshu.kv.dto.rsp.FindNoteContentRspDTO;
import org.springframework.cloud.openfeign.FeignClient;
import com.itpractice.xiaohongshu.kv.dto.constant.ApiConstants;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author cyb
 *
 * Feign 接口
 */
@FeignClient(name = ApiConstants.SERVICE_NAME)
public interface KeyValueFeignApi {

    String PREFIX = "/kv";

    /**
     * 添加笔记内容
     *
     * @param addNoteContentReqDTO
     * @return
     */
    @PostMapping(value = PREFIX + "/note/content/add")
    Response<?> addNoteContent(@RequestBody AddNoteContentReqDTO addNoteContentReqDTO);

    /**
     * 查询笔记内容
     *
     * @param findNoteContentReqDTO
     * @return
     */
    @PostMapping(value = PREFIX + "/note/content/find")
    Response<FindNoteContentRspDTO> findNoteContent(@RequestBody FindNoteContentReqDTO findNoteContentReqDTO);

    /**
     * 删除笔记内容
     *
     * @param deleteNoteContentReqDTO
     * @return
     */
    @PostMapping(value = PREFIX + "/note/content/delete")
    Response<?> deleteNoteContent(@RequestBody DeleteNoteContentReqDTO deleteNoteContentReqDTO);
}
