package com.spring.beans.factory;

import com.spring.beans.exception.BeansException;
import com.spring.beans.factory.config.AutowireCapableFactory;
import com.spring.beans.factory.config.BeanDefinition;
import com.spring.beans.factory.config.ConfigurableBeanFactory;
import com.spring.beans.factory.ListableBeanFactory;

/**
 * @author zhangqingyang
 * @date 2022-07-05-10:01
 */
public interface ConfigrableListableBeanFactory extends ListableBeanFactory, ConfigurableBeanFactory, AutowireCapableFactory {
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
