package com.spring.beans.factory.support;

import com.spring.beans.factory.config.BeanDefinition;
import com.spring.enums.BeansResCodeEnum;
import com.spring.exception.SpringException;

import java.lang.reflect.Constructor;

import static com.spring.enums.BeansResCodeEnum.BEANS_RES_CODE_ENUM;

/**
 * @author zhangqingyang
 * @date 2022-06-30-19:34
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{
    @Override
    Object createBean(String beanName, BeanDefinition beanDefinition) {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        addSingleton(beanName, bean);
        return bean;

    }
}
