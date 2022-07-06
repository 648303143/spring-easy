package bean;

import com.spring.beans.exception.BeansException;
import com.spring.beans.factory.*;
import com.spring.context.ApplicationContext;
import lombok.Data;

/**
 * @author zhangqingyang
 * @date 2022-07-01-10:01
 */
@Data
public class UserService implements InitializingBean, DisposableBean , BeanNameAware, BeanClassLoaderAware, ApplicationContextAware,BeanFactoryAware {
    private String uId;
    private UserDAO userDao;
    private String location;
    private String company;
    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

    public String queryUserInfo(Long uid) {
        return userDao.queryUserName(uid) + "location" + location + "company" + company;
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("执行：UserService.destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行：UserService.afterPropertiesSet");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext");
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("ClassLoader:" + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanName:" + name);
    }
}
