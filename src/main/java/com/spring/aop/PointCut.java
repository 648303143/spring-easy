package com.spring.aop;


/**
 * @author zhangqingyang
 * @date 2022-07-08-10:44
 */
public interface PointCut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();

}
