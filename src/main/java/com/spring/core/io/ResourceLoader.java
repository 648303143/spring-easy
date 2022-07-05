package com.spring.core.io;

/**
 * @author zhangqingyang
 * @date 2022-07-04-17:53
 */
public interface ResourceLoader{

    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
