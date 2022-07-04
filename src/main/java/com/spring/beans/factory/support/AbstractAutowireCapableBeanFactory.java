package com.spring.beans.factory.support;

import com.spring.beans.factory.config.BeanDefinition;
import com.spring.exception.BeansException;

import java.lang.reflect.Constructor;


/**
 * @author zhangqingyang
 * @date 2022-06-30-19:34
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStragy();

    @Override
    Object createBean(String beanName, BeanDefinition beanDefinition) {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("[createBean error] beanName:" + beanName, e);
        }

        addSingleton(beanName, bean);
        return bean;

    }

    @Override
    Object createBean(String beanName, BeanDefinition beanDefinition, Object... args) {
        Object bean = null;
        try {
            bean = createInstance(beanName, beanDefinition, args);
        } catch (Exception e) {
            throw new BeansException("[createBean error] beanName:" + beanName, e);
        }

        addSingleton(beanName, bean);
        return bean;
    }

    private Object createInstance(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Constructor constructorToUse = null;
        Class beanClass = beanDefinition.getBeanClass();
        Constructor[] constructors = beanClass.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            if (args != null && constructor.getParameterTypes().length == args.length) {
                constructorToUse = constructor;
                break;
            }
        }
        return instantiationStrategy.instantiate(beanDefinition, beanName, constructorToUse, args);
    }
}
