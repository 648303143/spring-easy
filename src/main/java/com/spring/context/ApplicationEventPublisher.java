package com.spring.context;

/**
 * @author zhangqingyang
 * @date 2022-07-07-16:10
 */
public interface ApplicationEventPublisher {

    void publishEvent(ApplicationEvent event);
}
