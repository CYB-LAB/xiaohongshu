package com.itpractice.xiaohongshu.count.biz.service;

import com.itpractice.framework.common.response.Response;
import com.itpractice.xiaohongshu.count.dto.FindNoteCountsByIdRspDTO;
import com.itpractice.xiaohongshu.count.dto.FindNoteCountsByIdsReqDTO;

import java.util.List;

/**
 * @author cyb
 *
 * 笔记计数服务
 */
public interface NoteCountService {

    /**
     * 批量查询笔记计数
     * @param findNoteCountsByIdsReqDTO
     * @return
     */
    Response<List<FindNoteCountsByIdRspDTO>> findNotesCountData(FindNoteCountsByIdsReqDTO findNoteCountsByIdsReqDTO);
}
