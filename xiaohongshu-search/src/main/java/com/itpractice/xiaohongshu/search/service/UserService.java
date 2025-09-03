package com.itpractice.xiaohongshu.search.service;

import com.itpractice.framework.common.response.PageResponse;
import com.itpractice.xiaohongshu.search.model.vo.SearchUserReqVO;
import com.itpractice.xiaohongshu.search.model.vo.SearchUserRspVO;

/**
 * @author cyb
 *
 * 用户搜索业务
 */
public interface UserService {

    /**
     * 搜索用户
     * @param searchUserReqVO
     * @return
     */
    PageResponse<SearchUserRspVO> searchUser(SearchUserReqVO searchUserReqVO);
}
