package com.itpractice.framework.common.exception;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author cyb
 *
 * 自定义业务异常
 */

@Getter
@Setter
public class BizException extends RuntimeException{
    // 异常码
    private String errorCode;
    // 错误信息
    private String errorMessage;

    public BizException(BaseExceptionInterface baseExceptionInterface) {
        this.errorCode = baseExceptionInterface.getErrorCode();
        this.errorMessage = baseExceptionInterface.getErrorMessage();
    }
}
