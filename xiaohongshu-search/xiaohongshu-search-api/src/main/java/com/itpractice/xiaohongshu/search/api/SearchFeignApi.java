package com.itpractice.xiaohongshu.search.api;

import com.itpractice.framework.common.response.Response;
import com.itpractice.xiaohongshu.search.constant.ApiConstants;
import com.itpractice.xiaohongshu.search.dto.RebuildNoteDocumentReqDTO;
import com.itpractice.xiaohongshu.search.dto.RebuildUserDocumentReqDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author cyb
 *
 * 搜索服务Feign接口
 */
@FeignClient(name = ApiConstants.SERVICE_NAME)
public interface SearchFeignApi {

    String PREFIX = "/search";

    /**
     * 重建笔记文档
     * @param rebuildNoteDocumentReqDTO
     * @return
     */
    @PostMapping(value = PREFIX + "/note/document/rebuild")
    Response<?> rebuildNoteDocument(@RequestBody RebuildNoteDocumentReqDTO rebuildNoteDocumentReqDTO);


    /**
     * 重建用户文档
     * @param rebuildUserDocumentReqDTO
     * @return
     */
    @PostMapping(value = PREFIX + "/user/document/rebuild")
    Response<?> rebuildUserDocument(@RequestBody RebuildUserDocumentReqDTO rebuildUserDocumentReqDTO);

}
