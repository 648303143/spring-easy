import bean.UserService;
import com.spring.beans.factory.support.DefaultListableBeanFactory;
import com.spring.beans.factory.xml.XmlBeanDefinitionReader;
import com.spring.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;
import processor.MyBeanFactoryPostProcessor;
import processor.MyBeanPostProcessor;

/**
 * @author zhangqingyang
 * @date 2022-07-06-10:44
 */
public class ApplicationContextTest {

    @Test
    public void test_PostProcessor(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader definitionReader = new XmlBeanDefinitionReader(beanFactory);
        definitionReader.loadBeanDefinitions("classpath:spring.xml");

        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        UserService userService = beanFactory.getBean("userService", UserService.class);
        System.out.println(userService.queryUserInfo(1L));
    }

    @Test
    public void test_applicationContext() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring1.xml");

        UserService userService = applicationContext.getBean("userService", UserService.class);

        System.out.println(userService.queryUserInfo(1L));

    }

}


