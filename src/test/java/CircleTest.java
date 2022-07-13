import bean4.Husband;
import bean4.Wife;
import com.spring.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @author zhangqingyang
 * @date 2022-07-13-17:02
 */
public class CircleTest {
    @Test
    public void test_circular() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring7.xml");
        Husband husband = applicationContext.getBean("husband", Husband.class);
        Wife wife = applicationContext.getBean("wife", Wife.class);
        System.out.println("老公的媳妇：" + husband.queryWife());
        System.out.println("媳妇的老公：" + wife.queryHusband());
    }
}
