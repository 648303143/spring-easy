package com.spring.enums;

/**
 * @author zhangqingyang
 * @date 2022-07-01-10:34
 */
public interface IBaseResCodeEnum {
    String  getCode();
    String getMessage();
    default String getFullMessage(){
        return getCode() + ":" + getMessage();
    }

}
