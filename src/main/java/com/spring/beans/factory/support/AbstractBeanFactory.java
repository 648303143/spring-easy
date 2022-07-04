package com.spring.beans.factory.support;

import com.spring.beans.factory.BeanFactory;
import com.spring.beans.factory.config.BeanDefinition;
import com.spring.exception.SpringException;

/**
 * @author zhangqingyang
 * @date 2022-06-30-18:00
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String beanName) throws SpringException {
        Object bean = getSingleton(beanName);
        if (bean != null) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition);
    }

    abstract BeanDefinition getBeanDefinition(String beanName);

    abstract Object createBean(String beanName, BeanDefinition beanDefinition);
}
