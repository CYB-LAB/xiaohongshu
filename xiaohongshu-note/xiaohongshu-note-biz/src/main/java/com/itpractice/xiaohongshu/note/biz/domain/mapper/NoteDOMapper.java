package com.itpractice.xiaohongshu.note.biz.domain.mapper;

import com.itpractice.xiaohongshu.note.biz.domain.dataobject.NoteDO;
import org.apache.ibatis.annotations.Param;

public interface NoteDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(NoteDO record);

    int insertSelective(NoteDO record);

    NoteDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NoteDO record);

    int updateByPrimaryKey(NoteDO record);

    int updateVisibleOnlyMe(NoteDO noteDO);

    int updateIsTop(NoteDO noteDO);

    int selectCountByNoteId(Long noteId);
}