package com.itpractice.xiaohongshu.data.align.domain.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @author cyb
 *
 * 添加记录
 */
public interface InsertRecordMapper {

    /**
     * 笔记点赞数：计数变更
     */
    void insert2DataAlignNoteLikeCountTempTable(@Param("tableNameSuffix") String tableNameSuffix, @Param("noteId") Long noteId);

    /**
     * 用户获得的点赞数：计数变更
     */
    void insert2DataAlignUserLikeCountTempTable(@Param("tableNameSuffix") String tableNameSuffix, @Param("userId") Long userId);
}
