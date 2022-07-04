package com.spring.beans.factory;

/**
 * @author zhangqingyang
 * @date 2022-06-30-17:54
 */
public interface BeanFactory {

    Object getBean(String beanName);
}
