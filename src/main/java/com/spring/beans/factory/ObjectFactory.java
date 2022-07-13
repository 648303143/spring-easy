package com.spring.beans.factory;

import com.spring.beans.exception.BeansException;

/**
 * @author zhangqingyang
 * @date 2022-07-13-16:10
 */
public interface ObjectFactory<T> {

    T getObject() throws BeansException;
}
