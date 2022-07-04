package impl;

/**
 * @author zhangqingyang
 * @date 2022-07-01-10:01
 */
public class UserService {
    private String name;

    public void queryUserInfo() {
        System.out.println("queryUserInfo");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserService(String name) {
        this.name = name;
    }
}
