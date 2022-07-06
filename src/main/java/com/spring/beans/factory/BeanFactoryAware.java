package com.spring.beans.factory;

import com.spring.beans.exception.BeansException;

/**
 * @author zhangqingyang
 * @date 2022-07-06-17:29
 */
public interface BeanFactoryAware extends Aware{
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
