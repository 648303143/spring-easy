package com.spring.beans.factory;

import com.spring.beans.exception.BeansException;

/**
 * @author zhangqingyang
 * @date 2022-06-30-17:54
 */
public interface BeanFactory {

    Object getBean(String beanName);

    Object getBean(String beanName, Object... args);

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
