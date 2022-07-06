import bean.UserService;
import com.spring.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @author zhangqingyang
 * @date 2022-07-06-17:51
 */
public class AwareTest {

    @Test
    public void test_aware() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");

        applicationContext.registerShutdownHook();

        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println(userService.queryUserInfo(3L));
        System.out.println(userService.getBeanFactory());
        System.out.println(userService.getApplicationContext());
    }
}
