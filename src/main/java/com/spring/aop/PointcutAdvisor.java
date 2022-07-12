package com.spring.aop;

/**
 * @author zhangqingyang
 * @date 2022-07-11-20:19
 */
public interface PointcutAdvisor extends Advisor{
    PointCut getPointcut();
}
