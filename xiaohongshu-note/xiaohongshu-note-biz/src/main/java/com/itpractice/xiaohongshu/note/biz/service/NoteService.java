package com.itpractice.xiaohongshu.note.biz.service;

import com.itpractice.framework.common.utils.Response;
import com.itpractice.xiaohongshu.note.biz.model.vo.FindNoteDetailReqVO;
import com.itpractice.xiaohongshu.note.biz.model.vo.FindNoteDetailRspVO;
import com.itpractice.xiaohongshu.note.biz.model.vo.PublishNoteReqVO;
import com.itpractice.xiaohongshu.note.biz.model.vo.UpdateNoteReqVO;

/**
 * @author cyb
 *
 * 笔记服务
 */
public interface NoteService {

    /**
     * 笔记发布
     * @param publishNoteReqVO
     * @return
     */
    Response<?> publishNote(PublishNoteReqVO publishNoteReqVO);

    /**
     * 笔记详情
     * @param findNoteDetailReqVO
     * @return
     */
    Response<FindNoteDetailRspVO> findNoteDetail(FindNoteDetailReqVO findNoteDetailReqVO);

    /**
     * 笔记更新
     * @param updateNoteReqVO
     * @return
     */
    Response<?> updateNote(UpdateNoteReqVO updateNoteReqVO);

}
