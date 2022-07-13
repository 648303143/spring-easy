package com.spring.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * @author zhangqingyang
 * @date 2022-07-13-10:21
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER,ElementType.TYPE,ElementType.ANNOTATION_TYPE})
@Inherited
@Documented
public @interface Qualifier {
    String value() default "";
}
