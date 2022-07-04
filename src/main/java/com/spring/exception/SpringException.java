package com.spring.exception;

import com.spring.enums.IBaseResCodeEnum;

/**
 * @author zhangqingyang
 * @date 2022-07-01-10:21
 */
public class SpringException extends BaseException{

    public SpringException(IBaseResCodeEnum resCodeEnum, Object[] params) {
        super(resCodeEnum.getCode(), resCodeEnum.getFullMessage(), params);
    }

    public SpringException(IBaseResCodeEnum resCodeEnum) {
        super(resCodeEnum.getCode(), resCodeEnum.getFullMessage(), null);
    }
}
