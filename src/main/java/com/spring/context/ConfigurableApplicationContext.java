package com.spring.context;

import com.spring.beans.exception.BeansException;

/**
 * @author zhangqingyang
 * @date 2022-07-05-15:50
 */
public interface ConfigurableApplicationContext extends ApplicationContext{

    void refresh() throws BeansException;

    void registerShutdownHook();

    void close();
}
