package com.spring.beans.factory.support;

import com.spring.beans.exception.BeansException;
import com.spring.core.io.Resource;
import com.spring.core.io.ResourceLoader;

/**
 * @author zhangqingyang
 * @date 2022-07-04-17:56
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

}
