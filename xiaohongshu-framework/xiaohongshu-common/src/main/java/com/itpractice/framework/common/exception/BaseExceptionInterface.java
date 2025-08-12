package com.itpractice.framework.common.exception;

/**
 * @author cyb
 *
 * 基础异常接口
 */
public interface BaseExceptionInterface {

    // 获取异常码
    String getErrorCode();

    // 获取异常信息
    String getErrorMessage();
}
