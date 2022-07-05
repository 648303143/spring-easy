package com.spring.beans.factory;

import com.spring.beans.exception.BeansException;
import com.spring.beans.factory.BeanFactory;

import java.util.Map;

/**
 * @author zhangqingyang
 * @date 2022-07-05-09:59
 */
public interface ListableBeanFactory extends BeanFactory {
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    String[] getBeanDefinitionNames();
}
