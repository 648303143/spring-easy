package com.spring.exception;

/**
 * @author zhangqingyang
 * @date 2022-07-01-10:18
 */
public class BaseException extends RuntimeException{
    String code;
    String msg;
    Object[] params;

    public BaseException(String code, String msg, Object[] params) {
        super(msg);
        this.code = code;
        this.msg = msg;
        this.params = params;
    }
}
