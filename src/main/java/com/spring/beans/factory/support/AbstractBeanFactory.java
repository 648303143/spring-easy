package com.spring.beans.factory.support;

import com.spring.beans.exception.BeansException;
import com.spring.beans.factory.BeanFactory;
import com.spring.beans.factory.config.BeanDefinition;
import com.spring.beans.factory.config.BeanPostProcessor;
import com.spring.util.ClassUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangqingyang
 * @date 2022-06-30-18:00
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();
    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

    @Override
    public Object getBean(String beanName){
        return doGetBean(beanName,null);
    }

    @Override
    public Object getBean(String beanName, Object... args) {
        return doGetBean(beanName, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName);

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object... args);

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor){
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }

    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }
}
