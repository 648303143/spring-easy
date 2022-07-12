package com.spring.stereotype;

import java.lang.annotation.*;

/**
 * @author zhangqingyang
 * @date 2022-07-12-14:48
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {
    String value() default "";
}
