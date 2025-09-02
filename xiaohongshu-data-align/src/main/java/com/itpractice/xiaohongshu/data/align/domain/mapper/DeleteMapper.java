package com.itpractice.xiaohongshu.data.align.domain.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author cyb
 *
 * 删除
 */
public interface DeleteMapper {

    /**
     * 日增量表：关注数计数变更 - 批量删除
     * @param userIds
     */
    void batchDeleteDataAlignFollowingCountTempTable(@Param("tableNameSuffix") String tableNameSuffix,
                                                     @Param("userIds") List<Long> userIds);

    /**
     * 日增量表：笔记点赞计数变更 - 批量删除
     */
    void batchDeleteDataAlignNoteLikeCountTempTable(@Param("tableNameSuffix") String tableNameSuffix,
                                                    @Param("noteIds") List<Long> noteIds);

    /**
     * 日增量表：笔记发布计数变更 - 批量删除
     */
    void batchDeleteDataAlignNotePublishCountTempTable(@Param("tableNameSuffix") String tableNameSuffix,
                                                       @Param("userIds") List<Long> userIds);

    /**
     * 日增量表：用户获得收藏计数变更 - 批量删除
     */
    void batchDeleteDataAlignUserCollectCountTempTable(@Param("tableNameSuffix") String tableNameSuffix,
                                                       @Param("userIds") List<Long> userIds);

    /**
     * 日增量表：用户获得点赞计数变更 - 批量删除
     */
    void batchDeleteDataAlignUserLikeCountTempTable(@Param("tableNameSuffix") String tableNameSuffix,
                                                    @Param("userIds") List<Long> userIds);

    /**
     * 日增量表：用户粉丝计数变更 - 批量删除
     */
    void batchDeleteDataAlignFansCountTempTable(@Param("tableNameSuffix") String tableNameSuffix,
                                                @Param("userIds") List<Long> userIds);

    /**
     * 日增量表：笔记收藏计数变更 - 批量删除
     */
    void batchDeleteDataAlignNoteCollectCountTempTable(@Param("tableNameSuffix") String tableNameSuffix,
                                                       @Param("noteIds") List<Long> noteIds);
}
