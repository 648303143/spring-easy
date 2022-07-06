package com.spring.beans.factory;

/**
 * @author zhangqingyang
 * @date 2022-07-06-14:08
 */
public interface DisposableBean {

    void destroy() throws Exception;
}
