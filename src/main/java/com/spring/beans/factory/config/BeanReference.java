package com.spring.beans.factory.config;

/**
 * @author zhangqingyang
 * @date 2022-07-04-16:06
 */
public class BeanReference {
    String beanName;

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }
}
