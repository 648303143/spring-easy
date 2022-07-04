package bean;

import lombok.Data;

/**
 * @author zhangqingyang
 * @date 2022-07-01-10:01
 */
@Data
public class UserService {
    private String uid;
    private UserDAO userDAO;

    public void queryUserInfo(Long uid) {
        System.out.println("queryUserName" + userDAO.queryUserName(uid));
    }

}
