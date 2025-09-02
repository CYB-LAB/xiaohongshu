package com.itpractice.xiaohongshu.data.align.domain.mapper;

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
    int updateUserFansTotalByUserId(Long userId, int fansTotal);

    /**
     * 更新 t_note_count 计数表笔记收藏数
     */
    int updateNoteCollectTotalByNoteId(Long noteId, int noteCollectTotal);
}
