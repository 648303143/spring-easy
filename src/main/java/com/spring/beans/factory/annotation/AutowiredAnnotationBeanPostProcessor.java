package com.spring.beans.factory.annotation;

import cn.hutool.core.bean.BeanUtil;
import com.spring.beans.PropertyValues;
import com.spring.beans.exception.BeansException;
import com.spring.beans.factory.BeanFactory;
import com.spring.beans.factory.BeanFactoryAware;
import com.spring.beans.factory.ConfigurableListableBeanFactory;
import com.spring.beans.factory.config.InstantiationAwareBeanPostProcessor;
import com.spring.util.ClassUtils;

import java.lang.reflect.Field;

/**
 * @author zhangqingyang
 * @date 2022-07-13-10:31
 */
public class AutowiredAnnotationBeanPostProcessor implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

    private ConfigurableListableBeanFactory beanFactory;


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        Class<?> clazz = bean.getClass();
        clazz = ClassUtils.isCglibProxyClass(clazz) ? clazz.getSuperclass() : clazz;

        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field declaredField : declaredFields) {
            Value valueAnnotation = declaredField.getAnnotation(Value.class);
            if (valueAnnotation != null) {
                String value = valueAnnotation.value();
                value = beanFactory.resolveEmbeddedValue(value);
                BeanUtil.setFieldValue(bean, declaredField.getName(), value);
            }
        }

        for (Field declaredField : declaredFields) {
            Autowired autowiredAnnotation = declaredField.getAnnotation(Autowired.class);
            if (autowiredAnnotation != null) {
                Class<?> fieldType = declaredField.getType();
                String dependentBeanName = null;
                Qualifier qualifierAnnotation = declaredField.getAnnotation(Qualifier.class);
                Object dependentBean = null;
                if (qualifierAnnotation != null) {
                    dependentBeanName = qualifierAnnotation.value();
                    dependentBean  = beanFactory.getBean(dependentBeanName, fieldType);
                }else {
                    dependentBean = beanFactory.getBean(fieldType);
                }
                BeanUtil.setFieldValue(bean, declaredField.getName(), dependentBean);
            }
        }

        return pvs;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
    }
}
