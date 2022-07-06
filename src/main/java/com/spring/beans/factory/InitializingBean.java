package com.spring.beans.factory;

/**
 * @author zhangqingyang
 * @date 2022-07-06-14:07
 */
public interface InitializingBean {

    void afterPropertiesSet() throws Exception;
}
