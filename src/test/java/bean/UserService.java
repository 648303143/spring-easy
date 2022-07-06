package bean;

import lombok.Data;

/**
 * @author zhangqingyang
 * @date 2022-07-01-10:01
 */
@Data
public class UserService {
    private String uId;
    private UserDAO userDao;
    private String location;
    private String company;

    public String queryUserInfo(Long uid) {
        return userDao.queryUserName(uid) + "location" + location + "company" + company;
    }

}
