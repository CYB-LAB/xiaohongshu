package com.itpractice.xiaohongshu.oss.biz.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author cyb
 *
 * 配置 Minio 存储桶名称
 */
@ConfigurationProperties(prefix = "storage.minio")
@Component
@Data
public class MinioProperties {

    private String endpoint;
    private String accessKey;
    private String secretKey;
}
