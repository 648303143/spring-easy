package com.spring.enums;

/**
 * @author zhangqingyang
 * @date 2022-07-01-10:39
 */
public enum BeansResCodeEnum implements IBaseResCodeEnum{
    BEANS_RES_CODE_ENUM("B001", "BEANS_RES_CODE_ENUM");

    private String code;
    private String msg;

    BeansResCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.msg;
    }
}
