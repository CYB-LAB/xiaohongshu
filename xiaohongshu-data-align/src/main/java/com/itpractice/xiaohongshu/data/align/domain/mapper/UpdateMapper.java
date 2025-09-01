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
}
