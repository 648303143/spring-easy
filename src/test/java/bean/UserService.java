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

    public void queryUserInfo(Long uid) {
        System.out.println("queryUserName:" + userDao.queryUserName(uid));
    }

}
