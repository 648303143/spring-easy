package com.spring.beans.factory.config;

import com.spring.beans.factory.HierarchicalBeanFactory;

/**
 * @author zhangqingyang
 * @date 2022-07-05-10:00
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory {
    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";
}
