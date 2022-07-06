package com.spring.context.support;

import com.spring.beans.exception.BeansException;
import com.spring.beans.factory.support.DefaultListableBeanBeanFactory;

/**
 * @author zhangqingyang
 * @date 2022-07-05-15:58
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext{
    private DefaultListableBeanBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    @Override
    public DefaultListableBeanBeanFactory getBeanFactory() {
        return beanFactory;
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanBeanFactory beanFactory);


    private DefaultListableBeanBeanFactory createBeanFactory() {
        return new DefaultListableBeanBeanFactory();
    }
}
