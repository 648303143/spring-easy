package com.spring.beans.factory.config;

import com.spring.beans.exception.BeansException;
import com.spring.beans.factory.BeanFactory;

/**
 * @author zhangqingyang
 * @date 2022-07-05-10:00
 */
public interface AutowireCapableBeanFactory extends BeanFactory {
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;

}
