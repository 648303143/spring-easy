import bean.UserDAO;
import bean.UserService;
import com.spring.beans.factory.PropertyValue;
import com.spring.beans.factory.PropertyValues;
import com.spring.beans.factory.config.BeanDefinition;
import com.spring.beans.factory.config.BeanReference;
import com.spring.beans.factory.support.DefaultListableBeanFactory;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author zhangqingyang
 * @date 2022-07-01-10:00
 */
public class TestDemo01 {
    @Test
    public void test01() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        String beanName = "userService";
        beanFactory.registerBeanDefinition(beanName, beanDefinition);

        UserService bean =(UserService) beanFactory.getBean(beanName);
        bean.queryUserInfo(1L);
        UserService bean1 = (UserService)beanFactory.getBean(beanName);
        bean1.queryUserInfo(1L);
    }

    @Test
    public void test02() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        String beanName = "userService";
        beanFactory.registerBeanDefinition(beanName, beanDefinition);

        UserService bean =(UserService) beanFactory.getBean(beanName, "zhangsan");
        bean.queryUserInfo(1L);
        UserService bean1 = (UserService)beanFactory.getBean(beanName);
        bean1.queryUserInfo(1L);
    }

    @Test
    public void test03() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerBeanDefinition("userDAO", new BeanDefinition(UserDAO.class));
        PropertyValues propertyValues = new PropertyValues(new ArrayList<>());
        propertyValues.addPropertyValue(new PropertyValue("uid", 1001L));
        propertyValues.addPropertyValue(new PropertyValue("userDAO", new BeanReference("userDAO")));
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class,propertyValues);
        beanFactory.registerBeanDefinition("userService",beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo(1L);
        UserService userService1 = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo(1L);
        UserService userService2 = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo(2L);
    }
}
