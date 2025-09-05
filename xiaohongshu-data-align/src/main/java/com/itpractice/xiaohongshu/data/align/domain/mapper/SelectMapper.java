package com.itpractice.xiaohongshu.data.align.domain.mapper;

import com.itpractice.xiaohongshu.data.align.domain.dataobject.MqFailedMessageDO;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author cyb
 * <p>
 * 查询
 */
public interface SelectMapper {

    /**
     * 日增量表：关注数计数变更 - 批量查询
     *
     * @param tableNameSuffix
     * @param batchSize
     * @return
     */
    List<Long> selectBatchFromDataAlignFollowingCountTempTable(@Param("tableNameSuffix") String tableNameSuffix,
                                                               @Param("batchSize") int batchSize);

    /**
     * 查询 t_following 关注表，获取关注总数
     *
     * @param userId
     * @return
     */
    int selectCountFromFollowingTableByUserId(long userId);

    /**
     * 日增量表：笔记点赞数变更 - 批量查询
     *
     * @param tableNameSuffix
     * @param batchSize
     * @return
     */
    List<Long> selectBatchFromDataAlignNoteLikeCountTempTable(@Param("tableNameSuffix") String tableNameSuffix,
                                                              @Param("batchSize") int batchSize);

    /**
     * 查询 t_note_like 笔记点赞表，获取点赞总数
     *
     * @param noteId
     * @return
     */
    int selectCountFromNoteLikeTableByUserId(long noteId);


    /**
     * 日增量表：笔记发布数变更 - 批量查询
     *
     * @param tableNameSuffix
     * @param batchSize
     * @return
     */
    List<Long> selectBatchFromDataAlignNotePublishCountTempTable(@Param("tableNameSuffix") String tableNameSuffix,
                                                                 @Param("batchSize") int batchSize);

    /**
     * 查询 t_note 笔记表 获取用户笔记发布总数
     *
     * @param userId
     * @return
     */
    int selectCountFromNoteTableByUserId(Long userId);

    /**
     * 日增量表：笔记收藏数变更 - 批量查询
     *
     * @param tableNameSuffix
     * @param batchSize
     * @return
     */
    List<Long> selectBatchFromDataAlignUserCollectCountTempTable(@Param("tableNameSuffix") String tableNameSuffix,
                                                                 @Param("batchSize") int batchSize);

    /**
     * 获取用户收藏笔记总数
     *
     * @param userId
     * @return
     */
    int selectUserCollectCountFromNoteCollectionTableByUserId(Long userId);

    /**
     * 日增量表：用户获得点赞数变更 - 批量查询
     *
     * @param tableNameSuffix
     * @param batchSize
     * @return
     */
    List<Long> selectBatchFromDataAlignUserLikeCountTempTable(@Param("tableNameSuffix") String tableNameSuffix,
                                                              @Param("batchSize") int batchSize);

    /**
     * 获取用户获得点赞总数
     *
     * @param userId
     * @return
     */
    int selectUserCountFromNoteLikeTableByUserId(Long userId);

    /**
     * 日增量表：用户粉丝数变更 - 批量查询
     *
     * @param tableNameSuffix
     * @param batchSize
     * @return
     */
    List<Long> selectBatchFromDataAlignFansCountTempTable(@Param("tableNameSuffix") String tableNameSuffix,
                                                          @Param("batchSize") int batchSize);

    /**
     * 获取用户粉丝总数
     *
     * @param userId
     * @return
     */
    int selectCountFromFansTableByUserId(Long userId);

    /**
     * 日增量表：笔记收藏数变更 - 批量查询
     *
     * @param tableNameSuffix
     * @param batchSize
     * @return
     */
    List<Long> selectBatchFromDataAlignNoteCollectCountTempTable(@Param("tableNameSuffix") String tableNameSuffix,
                                                                 @Param("batchSize") int batchSize);

    /**
     * 获取笔记收藏总数
     *
     * @param noteId
     * @return
     */
    int selectNoteCollectCountFromNoteCollectionTableByNoteId(Long noteId);

    /**
     * 查询待重试的消息
     *
     * @param currentTime
     * @param batchSize
     * @return
     */
    List<MqFailedMessageDO> selectPendingMessages(@Param("currentTime") LocalDateTime currentTime,
                                                  @Param("batchSize") int batchSize);
}
