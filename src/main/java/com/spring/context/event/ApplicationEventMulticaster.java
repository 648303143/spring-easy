package com.spring.context.event;

import com.spring.context.ApplicationEvent;
import com.spring.context.ApplicationListener;

/**
 * @author zhangqingyang
 * @date 2022-07-07-15:54
 */
public interface ApplicationEventMulticaster {

    void addApplicationListener(ApplicationListener<?> listener);

    void removeApplicationListener(ApplicationListener<?> listener);

    void multicastEvent(ApplicationEvent event);
}
