package com.spring.beans.factory;

/**
 * @author zhangqingyang
 * @date 2022-07-06-17:29
 */
public interface BeanNameAware extends Aware{
    void setBeanName(String name);

}
