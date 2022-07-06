package com.spring.beans.factory.config;

import com.spring.beans.exception.BeansException;

/**
 * @author zhangqingyang
 * @date 2022-07-05-15:48
 */
public interface BeanPostProcessor {

    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
