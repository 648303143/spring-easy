package com.spring.context;

import java.util.EventObject;

/**
 * @author zhangqingyang
 * @date 2022-07-07-15:51
 */
public abstract class ApplicationEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
