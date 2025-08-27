package com.itpractice.xiaohongshu.note.biz.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author cyb
 *
 * 时间工具类
 */
public class DateUtils {

    /**
     * LocalDateTime 转时间戳
     *
     * @param localDateTime
     * @return
     */
    public static long localDateTime2Timestamp(LocalDateTime localDateTime) {
        return localDateTime.toInstant(ZoneOffset.UTC).toEpochMilli();
    }
}
