package com.spring.aop;

import lombok.Data;
import org.aopalliance.intercept.MethodInterceptor;

/**
 * @author zhangqingyang
 * @date 2022-07-08-10:59
 */
@Data
public class AdvisedSupport {

    private TargetSource targetSource;
    private MethodInterceptor methodInterceptor;
    private MethodMatcher methodMatcher;
}
