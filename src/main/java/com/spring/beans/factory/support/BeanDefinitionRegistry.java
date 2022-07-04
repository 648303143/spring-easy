package com.spring.beans.factory.support;

import com.spring.beans.factory.config.BeanDefinition;

/**
 * @author zhangqingyang
 * @date 2022-06-30-19:43
 */
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
