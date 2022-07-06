import bean.UserService;
import com.spring.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @author zhangqingyang
 * @date 2022-07-06-16:36
 */
public class InitAndDestroyTest {

    @Test
    public void test_initAndDestroy() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        UserService userService = applicationContext.getBean("userService", UserService.class);
        String userInfo = userService.queryUserInfo(2L);
        System.out.println(userInfo);

    }
}
