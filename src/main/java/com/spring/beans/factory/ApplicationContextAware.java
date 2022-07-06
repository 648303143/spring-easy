package com.spring.beans.factory;

import com.spring.beans.exception.BeansException;
import com.spring.context.ApplicationContext;

/**
 * @author zhangqingyang
 * @date 2022-07-06-17:30
 */
public interface ApplicationContextAware extends Aware{
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
