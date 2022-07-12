package com.spring.aop;

import java.lang.reflect.Method;

/**
 * @author zhangqingyang
 * @date 2022-07-11-20:17
 */
public interface MethodBeforeAdvice extends BeforeAdvice{

    void before(Method method, Object[] args, Object target) throws Throwable;
}
