package com.spring.beans.factory.support;

import com.spring.beans.factory.config.BeanPostProcessor;
import com.spring.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangqingyang
 * @date 2022-06-30-18:01
 */
public abstract class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private final Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    public void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName,singletonObject);
    }


    public abstract void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
