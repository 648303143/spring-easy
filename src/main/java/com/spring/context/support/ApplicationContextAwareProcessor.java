package com.spring.context.support;

import com.spring.beans.exception.BeansException;
import com.spring.beans.factory.ApplicationContextAware;
import com.spring.beans.factory.config.BeanPostProcessor;
import com.spring.context.ApplicationContext;

/**
 * @author zhangqingyang
 * @date 2022-07-06-17:32
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
