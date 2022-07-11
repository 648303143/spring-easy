package com.spring.aop;

import java.lang.reflect.Method;

/**
 * @author zhangqingyang
 * @date 2022-07-08-10:46
 */
public interface MethodMatcher {

    boolean matches(Method method, Class<?> targetClass);
}
