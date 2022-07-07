package bean;

import com.spring.beans.exception.BeansException;
import com.spring.beans.factory.BeanFactory;
import com.spring.context.ApplicationContext;
import lombok.Data;
import lombok.ToString;

/**
 * @author zhangqingyang
 * @date 2022-07-07-11:53
 */

public class UserService1 {
    private String uId;
    private String company;
    private String location;
    private IUserDAO userDao;

    public String queryUserInfo() {
        return userDao.queryUserName(uId) + "," + company + "," + location;
    }

    public UserService1() {
    }

    public UserService1(String uId, String company, String location, IUserDAO userDao) {
        this.uId = uId;
        this.company = company;
        this.location = location;
        this.userDao = userDao;
    }


    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public IUserDAO getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDAO userDao) {
        this.userDao = userDao;
    }
}
