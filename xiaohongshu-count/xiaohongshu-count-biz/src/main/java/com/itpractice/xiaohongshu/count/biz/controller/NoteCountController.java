package com.itpractice.xiaohongshu.count.biz.controller;

import com.itpractice.framework.biz.operationlog.aspect.ApiOperationLog;
import com.itpractice.framework.common.response.Response;
import com.itpractice.xiaohongshu.count.biz.service.NoteCountService;
import com.itpractice.xiaohongshu.count.dto.FindNoteCountsByIdRspDTO;
import com.itpractice.xiaohongshu.count.dto.FindNoteCountsByIdsReqDTO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/count")
@Slf4j
public class NoteCountController {

    @Resource
    private NoteCountService noteCountService;

    @PostMapping(value = "/notes/data")
    @ApiOperationLog(description = "批量获取笔记计数数据")
    public Response<List<FindNoteCountsByIdRspDTO>> findNotesCountData(@Validated @RequestBody FindNoteCountsByIdsReqDTO findNoteCountsByIdsReqDTO) {
        return noteCountService.findNotesCountData(findNoteCountsByIdsReqDTO);
    }
}
