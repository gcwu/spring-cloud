package com.common.base.exception;

/**
 * @author 陶江航
 * @date 2017/8/30
 * @description 验证异常，比如验证时间格式不正确会抛出这个异常
 */
public class VerifyException extends Exception {
    public VerifyException() {
    }

    public VerifyException(String message) {
        super(message);
    }
}
