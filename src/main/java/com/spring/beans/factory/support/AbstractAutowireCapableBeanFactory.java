package com.spring.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.spring.beans.factory.PropertyValue;
import com.spring.beans.factory.PropertyValues;
import com.spring.beans.factory.config.BeanDefinition;
import com.spring.beans.factory.config.BeanReference;
import com.spring.exception.BeansException;

import java.lang.reflect.Constructor;
import java.util.List;


/**
 * @author zhangqingyang
 * @date 2022-06-30-19:34
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStragy();

    @Override
    Object createBean(String beanName, BeanDefinition beanDefinition) {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
            applyPropertyValues(bean,beanName,beanDefinition);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("[createBean error] beanName:" + beanName, e);
        }

        addSingleton(beanName, bean);
        return bean;

    }

    @Override
    Object createBean(String beanName, BeanDefinition beanDefinition, Object... args) {
        Object bean = null;
        try {
            bean = createInstance(beanName, beanDefinition, args);
            applyPropertyValues(bean,beanName,beanDefinition);
        } catch (Exception e) {
            throw new BeansException("[createBean error] beanName:" + beanName, e);
        }

        addSingleton(beanName, bean);
        return bean;
    }

    private void applyPropertyValues(Object bean, String beanName, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                if (value instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                BeanUtil.setFieldValue(bean,name,value);
            }
        } catch (Exception e) {
            throw new BeansException("[applyPropertyValues error] beanName:"+beanName);
        }
    }

    private Object createInstance(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Constructor constructorToUse = null;
        Class beanClass = beanDefinition.getBeanClass();
        Constructor[] constructors = beanClass.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            if (args != null && constructor.getParameterTypes().length == args.length) {
                constructorToUse = constructor;
                break;
            }
        }
        return instantiationStrategy.instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
