package com.itpractice.xiaohongshu.oss.biz.service.impl;

import com.itpractice.framework.common.response.Response;
import com.itpractice.xiaohongshu.oss.biz.service.FileService;
import com.itpractice.xiaohongshu.oss.biz.strategy.FileStrategy;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author cyb
 *
 * 文件业务实现类
 */
@Service
@Slf4j
public class FileServiceImpl implements FileService {
    @Resource
    private FileStrategy fileStrategy;

    private static final String BUCKET_NAME = "xiaohongshu";

    @Override
    public Response<?> uploadFile(MultipartFile file) {
        // 上传文件
        String url = null;
        try {
            url = fileStrategy.uploadFile(file, BUCKET_NAME);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return Response.success(url);
    }
}
