package com.itpractice.xiaohongshu.kv.biz.service;

import com.itpractice.framework.common.utils.Response;
import com.itpractice.xiaohongshu.kv.dto.req.AddNoteContentReqDTO;
import com.itpractice.xiaohongshu.kv.dto.req.DeleteNoteContentReqDTO;
import com.itpractice.xiaohongshu.kv.dto.req.FindNoteContentReqDTO;
import com.itpractice.xiaohongshu.kv.dto.rsp.FindNoteContentRspDTO;

/**
 * @author cyb
 *
 * 笔记内容服务
 */
public interface NoteContentService {

    /**
     * 添加笔记内容
     *
     * @param addNoteContentReqDTO
     * @return
     */
    Response<?> addNoteContent(AddNoteContentReqDTO addNoteContentReqDTO);

    /**
     * 查询笔记内容
     *
     * @param findNoteContentReqDTO
     * @return
     */
    Response<FindNoteContentRspDTO> findNoteContent(FindNoteContentReqDTO findNoteContentReqDTO);

    /**
     * 删除笔记内容
     *
     * @param deleteNoteContentReqDTO
     * @return
     */
    Response<?> deleteNoteContent(DeleteNoteContentReqDTO deleteNoteContentReqDTO);
}
