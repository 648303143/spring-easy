package com.spring.beans.factory.config;

import com.spring.beans.factory.HierarchicalBeanFactory;
import com.spring.util.StringValueResolver;

/**
 * @author zhangqingyang
 * @date 2022-07-05-10:00
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {
    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    void destroySingletons();

    void addEmbeddedValueResolver(StringValueResolver valueResolver);

    String resolveEmbeddedValue(String value);
}
