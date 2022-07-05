package com.spring.beans;

import com.spring.beans.PropertyValue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangqingyang
 * @date 2022-07-04-16:08
 */
public class PropertyValues {
    List<PropertyValue> propertyValueList = new ArrayList<>();

    public PropertyValues(List<PropertyValue> propertyValueList) {
        this.propertyValueList = propertyValueList;
    }

    public PropertyValues() {
    }

    public boolean addPropertyValue(PropertyValue propertyValue) {
        return propertyValueList.add(propertyValue);
    }

    public List<PropertyValue> getPropertyValues() {
        return propertyValueList;
    }
}
