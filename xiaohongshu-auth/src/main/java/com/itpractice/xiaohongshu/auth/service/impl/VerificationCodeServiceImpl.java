package com.itpractice.xiaohongshu.auth.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.itpractice.framework.common.exception.BizException;
import com.itpractice.framework.common.utils.Response;
import com.itpractice.xiaohongshu.auth.constant.RedisKeyConstants;
import com.itpractice.xiaohongshu.auth.domain.mapper.UserDOMapper;
import com.itpractice.xiaohongshu.auth.enums.LoginTypeEnum;
import com.itpractice.xiaohongshu.auth.enums.ResponseCodeEnum;
import com.itpractice.xiaohongshu.auth.model.vo.user.UserLoginReqVO;
import com.itpractice.xiaohongshu.auth.model.vo.verificationcode.SendVerificationCodeReqVO;
import com.itpractice.xiaohongshu.auth.service.VerificationCodeService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class VerificationCodeServiceImpl implements VerificationCodeService {


    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 发送短信验证码
     *
     * @param sendVerificationCodeReqVO
     * @return
     */
    @Override
    public Response<?> send(SendVerificationCodeReqVO sendVerificationCodeReqVO) {
        // 手机号
        String phone = sendVerificationCodeReqVO.getPhone();

        // 构建验证码 redis key
        String key = RedisKeyConstants.buildVerificationCodeKey(phone);

        // 判断是否已发送验证码
        boolean isSent = redisTemplate.hasKey(key);
        if (isSent) {
            // 若之前发送的验证码未过期，则提示发送频繁
            throw new BizException(ResponseCodeEnum.VERIFICATION_CODE_SEND_FREQUENTLY);
        }

        // 生成 6 位随机数字验证码
        String verificationCode = RandomUtil.randomNumbers(6);

        // todo: 调用第三方短信发送服务

        log.info("==> 手机号: {}, 已发送验证码：【{}】", phone, verificationCode);

        // 存储验证码到 redis, 并设置过期时间为 3 分钟
        redisTemplate.opsForValue().set(key, verificationCode, 3, TimeUnit.MINUTES);

        return Response.success();
    }
}
