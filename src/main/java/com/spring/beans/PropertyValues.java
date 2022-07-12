package com.spring.beans;

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

    public void addPropertyValue(PropertyValue propertyValue) {
        propertyValueList.add(propertyValue);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue pv : this.propertyValueList) {
            if (pv.getName().equals(propertyName)) {
                return pv;
            }
        }
        return null;
    }
}
