package com.spring.beans.factory.support;

import com.spring.beans.factory.config.BeanDefinition;
import com.spring.beans.exception.BeansException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author zhangqingyang
 * @date 2022-07-04-11:49
 */
public class SimpleInstantiationStragy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object... args) {
        Class beanClass = beanDefinition.getBeanClass();
        try {
            if (constructor != null) {
                return beanClass.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            }else {
                return beanClass.getDeclaredConstructor().newInstance();
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new BeansException("[instantiate 出错] beanClass:" + beanClass.getName(),e);
        }
    }
}
