import bean.UserService;
import cn.hutool.core.io.IoUtil;
import com.spring.beans.factory.support.DefaultListableBeanBeanFactory;
import com.spring.beans.factory.xml.XmlBeanDefinitionReader;
import com.spring.core.io.DefaultResourceLoader;
import com.spring.core.io.Resource;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhangqingyang
 * @date 2022-07-05-10:59
 */
public class XmlResourceLoaderTest {

    @Test
    public void test_classpath() throws IOException {
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }
    @Test
    public void test_file() throws IOException {
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("src/main/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }
    @Test
    public void test_url() throws IOException {
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_xml() {
        DefaultListableBeanBeanFactory beanFactory = new DefaultListableBeanBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        reader.loadBeanDefinitions("classpath:spring.xml");

        UserService userService = beanFactory.getBean("userService",UserService.class);

        userService.queryUserInfo(2L);
    }
}
