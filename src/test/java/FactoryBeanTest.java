import bean.UserService;
import bean.UserService1;
import com.spring.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

/**
 * @author zhangqingyang
 * @date 2022-07-07-14:12
 */
public class FactoryBeanTest {

    @Test
    public void test_prototype() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring2.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService1 userService01 = applicationContext.getBean("userService", UserService1.class);
        UserService1 userService02 = applicationContext.getBean("userService", UserService1.class);

        // 3. 配置 scope="prototype/singleton"
        System.out.println(userService01);
        System.out.println(userService02);

        // 4. 打印十六进制哈希
        System.out.println(userService01 + " 十六进制哈希：" + Integer.toHexString(userService01.hashCode()));
        System.out.println(ClassLayout.parseInstance(userService01).toPrintable());

    }


    @Test
    public void test_factory_bean() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring2.xml");
        applicationContext.registerShutdownHook();

        // 2. 调用代理方法
        UserService1 userService = applicationContext.getBean("userService", UserService1.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }

}
