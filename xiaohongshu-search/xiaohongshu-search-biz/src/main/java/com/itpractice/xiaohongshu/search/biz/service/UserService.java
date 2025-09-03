package com.itpractice.xiaohongshu.search.biz.service;


import com.itpractice.framework.common.response.PageResponse;
import com.itpractice.framework.common.response.Response;
import com.itpractice.xiaohongshu.search.biz.model.vo.SearchUserReqVO;
import com.itpractice.xiaohongshu.search.biz.model.vo.SearchUserRspVO;
import com.itpractice.xiaohongshu.search.dto.RebuildUserDocumentReqDTO;

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

    /**
     * 重建用户文档
     * @param rebuildUserDocumentReqDTO
     * @return
     */
    Response<Long> rebuildDocument(RebuildUserDocumentReqDTO rebuildUserDocumentReqDTO);
}
