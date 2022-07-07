package com.spring.beans.factory.config;

import com.spring.beans.exception.BeansException;
import com.spring.beans.factory.ConfigurableListableBeanFactory;

/**
 * @author zhangqingyang
 * @date 2022-07-05-15:47
 */
public interface BeanFactoryPostProcessor {

    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
