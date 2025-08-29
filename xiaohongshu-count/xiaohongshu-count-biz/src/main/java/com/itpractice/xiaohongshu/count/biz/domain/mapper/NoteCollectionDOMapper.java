package com.itpractice.xiaohongshu.count.biz.domain.mapper;

import com.itpractice.xiaohongshu.count.biz.domain.dataobject.NoteCollectionDO;
import org.apache.ibatis.annotations.Param;

public interface NoteCollectionDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(NoteCollectionDO record);

    int insertSelective(NoteCollectionDO record);

    NoteCollectionDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NoteCollectionDO record);

    int updateByPrimaryKey(NoteCollectionDO record);

}