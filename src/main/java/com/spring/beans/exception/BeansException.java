package com.spring.beans.exception;

/**
 * @author zhangqingyang
 * @date 2022-07-01-10:18
 */
public class BeansException extends RuntimeException{

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg,cause);
    }
}
