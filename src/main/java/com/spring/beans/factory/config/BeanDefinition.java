package com.spring.beans.factory.config;

import com.spring.beans.PropertyValues;
import lombok.Data;

/**
 * @author zhangqingyang
 * @date 2022-06-30-17:56
 */
@Data
public class BeanDefinition {
    private Class beanClass;
    private PropertyValues propertyValues;
    private String initMethodName;
    private String destroyMethodName;

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues;
    }

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

}
