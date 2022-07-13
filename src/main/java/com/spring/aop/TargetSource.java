package com.spring.aop;

import com.spring.util.ClassUtils;

public class TargetSource {

    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    public Class<?>[] getTargetClass(){
        if (ClassUtils.isCglibProxyClass(target.getClass())) {
            return this.target.getClass().getSuperclass().getInterfaces();
        }
        return this.target.getClass().getInterfaces();
    }

    public Object getTarget(){
        return this.target;
    }

}
