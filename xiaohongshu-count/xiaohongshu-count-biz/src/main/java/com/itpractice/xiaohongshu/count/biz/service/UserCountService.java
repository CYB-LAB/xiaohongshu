package com.itpractice.xiaohongshu.count.biz.service;

import com.itpractice.framework.common.response.Response;
import com.itpractice.xiaohongshu.count.dto.FindUserCountsByIdReqDTO;
import com.itpractice.xiaohongshu.count.dto.FindUserCountsByIdRspDTO;

/**
 * @author cyb
 *
 * 用户计数服务
 */
public interface UserCountService {

    /**
     * 查询用户相关计数
     * @param findUserCountsByIdReqDTO
     * @return
     */
    Response<FindUserCountsByIdRspDTO> findUserCountData(FindUserCountsByIdReqDTO findUserCountsByIdReqDTO);
}
