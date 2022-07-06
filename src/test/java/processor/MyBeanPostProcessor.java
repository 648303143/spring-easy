package processor;

import bean.UserService;
import com.spring.beans.exception.BeansException;
import com.spring.beans.factory.config.BeanPostProcessor;

/**
 * @author zhangqingyang
 * @date 2022-07-06-10:50
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("改为北京");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
