package com.spring.context.annotation;

import java.lang.annotation.*;

/**
 * @author zhangqingyang
 * @date 2022-07-12-14:46
 */

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {

    String value() default "singleton";
}
