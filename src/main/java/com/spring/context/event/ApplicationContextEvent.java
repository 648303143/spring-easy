package com.spring.context.event;

import com.spring.context.ApplicationContext;
import com.spring.context.ApplicationEvent;

/**
 * @author zhangqingyang
 * @date 2022-07-07-15:52
 */
public class ApplicationContextEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}
