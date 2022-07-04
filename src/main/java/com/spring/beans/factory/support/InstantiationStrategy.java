package com.spring.beans.factory.support;

import com.spring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author zhangqingyang
 * @date 2022-07-04-11:47
 */
public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object... args);
}
