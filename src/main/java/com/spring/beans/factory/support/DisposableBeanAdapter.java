package com.spring.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import com.spring.beans.exception.BeansException;
import com.spring.beans.factory.DisposableBean;
import com.spring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;
import java.sql.Struct;

/**
 * @author zhangqingyang
 * @date 2022-07-06-14:21
 */
public class DisposableBeanAdapter implements DisposableBean {
    private final Object bean;
    private final String beanName;
    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        if (bean instanceof DisposableBean){
            ((DisposableBean) bean).destroy();
        }

        if (StrUtil.isNotEmpty(destroyMethodName) && !(bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName))){
            Method method = bean.getClass().getMethod(destroyMethodName);
            if (method == null) {
                throw new BeansException("Couldn't find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");

            }
            method.invoke(bean);
        }
    }
}
