package com.spring.aop;

import org.aopalliance.aop.Advice;

/**
 * @author zhangqingyang
 * @date 2022-07-11-20:18
 */
public interface Advisor {

    Advice getAdvice();
}
