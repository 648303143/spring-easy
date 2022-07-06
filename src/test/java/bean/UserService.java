package bean;

import com.spring.beans.factory.DisposableBean;
import com.spring.beans.factory.InitializingBean;
import lombok.Data;

/**
 * @author zhangqingyang
 * @date 2022-07-01-10:01
 */
@Data
public class UserService implements InitializingBean, DisposableBean {
    private String uId;
    private UserDAO userDao;
    private String location;
    private String company;

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
}
