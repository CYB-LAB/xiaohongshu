package com.itpractice.xiaohongshu.auth.alarm.impl;

import com.itpractice.xiaohongshu.auth.alarm.AlarmInterface;
import lombok.extern.slf4j.Slf4j;

/**
 * @author cyb
 *
 * 短信通知
 */
@Slf4j
public class SmsAlarmHelper implements AlarmInterface {

    /**
     * 发送短信
     *
     * @param message
     * @return
     */
    @Override
    public boolean send(String message) {
        log.info("==> 短信通知：{}", message);



        return true;
    }
}
