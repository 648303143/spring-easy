package com.spring.beans.factory;

import com.spring.beans.PropertyValue;
import com.spring.beans.PropertyValues;
import com.spring.beans.exception.BeansException;
import com.spring.beans.factory.config.BeanDefinition;
import com.spring.beans.factory.config.BeanFactoryPostProcessor;
import com.spring.core.io.DefaultResourceLoader;
import com.spring.core.io.Resource;

import java.io.IOException;
import java.util.Properties;

/**
 * @author zhangqingyang
 * @date 2022-07-12-14:22
 */
public class PropertyPlaceholderConfigurer implements BeanFactoryPostProcessor {

    public static final String DEFAULT_PLACEHOLDER_PREFIX = "${";

    public static final String DEFAULT_PLACEHOLDER_SUFFIX = "}";

    private String location;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        try {
            DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
            Resource resource = resourceLoader.getResource(location);
            Properties properties = new Properties();
            properties.load(resource.getInputStream());

            String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
            for (String beanDefinitionName : beanDefinitionNames) {
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanDefinitionName);

                PropertyValues propertyValues = beanDefinition.getPropertyValues();
                for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                    Object value = propertyValue.getValue();
                    if (!(value instanceof String)) {
                        continue;
                    }
                    String strVal = (String) value;
                    StringBuilder stringBuilder = new StringBuilder(strVal);
                    int startIdx = strVal.indexOf(DEFAULT_PLACEHOLDER_PREFIX);
                    int endIdx = strVal.indexOf(DEFAULT_PLACEHOLDER_SUFFIX);
                    if (startIdx != -1 && endIdx != -1 && startIdx < endIdx) {
                        String propKey = strVal.substring(startIdx + 2, endIdx);
                        String propVal = properties.getProperty(propKey);
                        stringBuilder.replace(startIdx, endIdx+1, propVal);
                        propertyValues.addPropertyValue(new PropertyValue(propertyValue.getName(), stringBuilder.toString()));
                    }
                }
            }
        } catch (IOException e) {
            throw new BeansException("Could not load properties", e);
        }
    }
}
