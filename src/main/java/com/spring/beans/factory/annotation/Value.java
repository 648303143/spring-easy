package com.spring.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * @author zhangqingyang
 * @date 2022-07-13-10:30
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Value {

    String value();

}
