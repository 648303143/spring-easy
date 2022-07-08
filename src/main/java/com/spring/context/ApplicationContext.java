package com.spring.context;

import com.spring.beans.factory.HierarchicalBeanFactory;
import com.spring.beans.factory.ListableBeanFactory;
import com.spring.core.io.ResourceLoader;

/**
 * @author zhangqingyang
 * @date 2022-07-05-15:49
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
