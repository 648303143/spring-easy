import com.impl.UserService;
import com.spring.beans.factory.config.BeanDefinition;
import com.spring.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

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
        bean.queryUserInfo();
        UserService bean1 = (UserService)beanFactory.getBean(beanName);
        bean1.queryUserInfo();
    }
}
