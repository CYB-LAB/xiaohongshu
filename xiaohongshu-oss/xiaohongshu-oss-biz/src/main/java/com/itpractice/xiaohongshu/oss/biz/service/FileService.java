package com.itpractice.xiaohongshu.oss.biz.service;

import com.itpractice.framework.common.response.Response;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author cyb
 *
 * 文件业务接口
 */
public interface FileService {

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    Response<?> uploadFile(MultipartFile file);
}
