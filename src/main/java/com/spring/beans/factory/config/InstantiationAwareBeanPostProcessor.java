package com.spring.beans.factory.config;


import com.spring.beans.exception.BeansException;

public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {

    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;

}
