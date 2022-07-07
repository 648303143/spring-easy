package processor;

import com.spring.beans.PropertyValue;
import com.spring.beans.PropertyValues;
import com.spring.beans.exception.BeansException;
import com.spring.beans.factory.ConfigurableListableBeanFactory;
import com.spring.beans.factory.config.BeanDefinition;
import com.spring.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @author zhangqingyang
 * @date 2022-07-06-10:50
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }
}
