package com.itpractice.xiaohongshu.oss.biz.strategy;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author cyb
 *
 * 文件上传策略接口
 */
public interface FileStrategy {

    /**
     * 文件上传
     *
     * @param file
     * @param bucketName
     * @return
     */
    String uploadFile(MultipartFile file, String bucketName) throws IOException;
}
