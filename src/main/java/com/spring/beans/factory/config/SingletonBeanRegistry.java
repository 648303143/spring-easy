package com.spring.beans.factory.config;

/**
 * @author zhangqingyang
 * @date 2022-06-30-17:59
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

    void registerSingleton(String beanName, Object singletonObject);
}
