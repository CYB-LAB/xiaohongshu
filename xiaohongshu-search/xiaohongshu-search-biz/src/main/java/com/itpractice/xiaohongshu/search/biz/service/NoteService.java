package com.itpractice.xiaohongshu.search.biz.service;

import com.itpractice.framework.common.response.PageResponse;
import com.itpractice.xiaohongshu.search.biz.model.vo.SearchNoteReqVO;
import com.itpractice.xiaohongshu.search.biz.model.vo.SearchNoteRspVO;


/**
 * @author cyb
 *
 * 笔记搜索业务
 */
public interface NoteService {

    /**
     * 搜索笔记
     * @param searchNoteReqVO
     * @return
     */
    PageResponse<SearchNoteRspVO> searchNote(SearchNoteReqVO searchNoteReqVO);
}
