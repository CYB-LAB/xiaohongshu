package com.itpractice.xiaohongshu.auth.alarm.impl;

import com.itpractice.xiaohongshu.auth.alarm.AlarmInterface;
import lombok.extern.slf4j.Slf4j;

/**
 * @author cyb
 *
 * 邮件通知
 */
@Slf4j
public class MailAlarmHelper implements AlarmInterface {


    /**
     * 发送邮件
     *
     * @param message
     * @return
     */
    @Override
    public boolean send(String message) {
        log.info("==> 邮件通知：{}", message);

        return true;
    }
}
