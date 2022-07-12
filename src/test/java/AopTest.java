import bean1.IUserService;
import com.spring.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @author zhangqingyang
 * @date 2022-07-11-20:53
 */
public class AopTest {
    @Test
    public void test_aop() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring4.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }

}
