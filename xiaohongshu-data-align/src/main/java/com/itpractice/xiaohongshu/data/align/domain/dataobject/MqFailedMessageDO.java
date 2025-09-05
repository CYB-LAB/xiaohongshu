package com.itpractice.xiaohongshu.data.align.domain.dataobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author cyb
 *
 * MQ 失败消息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MqFailedMessageDO {

    private Long id;

    private String topic;

    private String messageBody;

    private Integer status;

    private Integer retryCount;

    private Integer maxRetryTimes;

    private LocalDateTime nextRetryTime;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String errorMsg;
}
