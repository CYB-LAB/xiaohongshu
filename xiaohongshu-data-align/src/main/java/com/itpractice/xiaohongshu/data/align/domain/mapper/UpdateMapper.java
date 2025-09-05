package com.itpractice.xiaohongshu.data.align.domain.mapper;

import com.itpractice.xiaohongshu.data.align.domain.dataobject.MqFailedMessageDO;
import org.apache.ibatis.annotations.Param;

/**
 * @author cyb
 *
 * 更新
 */
public interface UpdateMapper {

    /**
     * 更新 t_user_count 计数表总关注数
     * @param userId
     * @return
     */
    int updateUserFollowingTotalByUserId(@Param("userId") long userId,
                                         @Param("followingTotal") int followingTotal);

    /**
     * 更新 t_note_count 计数表笔记点赞数
     */
    int updateNoteLikeTotalByUserId(@Param("noteId") long noteId,
                                    @Param("noteLikeTotal") int noteLikeTotal);

    /**
     * 更新 t_user_count 计数表笔记发布数
     */
    int updateNotePublishTotalByNoteId(@Param("userId") Long userId,
                                       @Param("notePublishTotal") int notePublishTotal);

    /**
     * 更新 t_user_count 计数表笔记收藏数
     */
    int updateUserCollectTotalByUserId(@Param("userId") Long userId,
                                       @Param("userCollectTotal")int userCollectTotal);

    /**
     * 更新 t_user_count 计数表用户获得点赞数
     */
    int updateUserLikeTotalByUserId(@Param("userId") Long userId,
                                    @Param("userLikeTotal") int userLikeTotal);

    /**
     * 更新 t_user_count 计数表用户粉丝数
     */
    int updateUserFansTotalByUserId(@Param("userId") Long userId,
                                    @Param("fansTotal") int fansTotal);

    /**
     * 更新 t_note_count 计数表笔记收藏数
     */
    int updateNoteCollectTotalByNoteId(@Param("noteId") Long noteId,
                                       @Param("noteCollectTotal") int noteCollectTotal);


    /**
     * 更新 t_mq_failed_message 表
     */
    void updateRetryInfo(MqFailedMessageDO messageDO);
}
