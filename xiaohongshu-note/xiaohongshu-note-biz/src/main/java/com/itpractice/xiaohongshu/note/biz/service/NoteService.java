package com.itpractice.xiaohongshu.note.biz.service;

import com.itpractice.framework.common.utils.Response;
import com.itpractice.xiaohongshu.note.biz.model.vo.PublishNoteReqVO;

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
}
