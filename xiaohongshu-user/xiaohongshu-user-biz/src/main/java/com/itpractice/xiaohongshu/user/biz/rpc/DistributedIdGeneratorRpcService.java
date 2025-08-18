package com.itpractice.xiaohongshu.user.biz.rpc;

import com.itpractice.xiaohongshu.distributed.id.generator.api.DistributedIdGeneratorFeignApi;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @author cyb
 *
 * 分布式ID生成服务
 */
@Component
public class DistributedIdGeneratorRpcService {

    @Resource
    private DistributedIdGeneratorFeignApi distributedIdGeneratorFeignApi;

    /**
     * Leaf 号段模式：小红书 ID 业务标识
     */
    private static final String BIZ_TAG_XIAOHONGSHU_ID = "leaf-segment-xiaohongshu-id";

    /**
     * Leaf 号段模式：用户 ID 业务标识
     */
    private static final String BIZ_TAG_USER_ID = "leaf-segment-user-id";

    /**
     * 调用分布式 ID 生成服务生成小红书 ID
     *
     * @return
     */
    public String getXiaohongshuId() {
        return distributedIdGeneratorFeignApi.getSegmentId(BIZ_TAG_XIAOHONGSHU_ID);
    }

    /**
     * 调用分布式 ID 生成服务用户 ID
     *
     * @return
     */
    public String getUserId() {
        return distributedIdGeneratorFeignApi.getSegmentId(BIZ_TAG_USER_ID);
    }
}
