package bean;

import lombok.Data;

/**
 * @author zhangqingyang
 * @date 2022-07-07-11:52
 */

public interface IUserDAO {

    String queryUserName(String uId);
}
