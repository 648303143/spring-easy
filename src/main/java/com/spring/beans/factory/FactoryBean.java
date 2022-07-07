package com.spring.beans.factory;

/**
 * @author zhangqingyang
 * @date 2022-07-07-11:21
 */
public interface FactoryBean<T> {

    T getObject() throws Exception;

    Class<?> getObjectType();

    boolean isSingleton();
}
