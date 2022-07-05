package com.spring.beans;

/**
 * @author zhangqingyang
 * @date 2022-07-04-16:07
 */
public class PropertyValue {
    String name;
    Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
