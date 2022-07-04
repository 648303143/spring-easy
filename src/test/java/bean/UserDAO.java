package bean;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangqingyang
 * @date 2022-07-04-16:23
 */

@Data
public class UserDAO {

    private static Map<Long,String> map = new HashMap<>(3);

    {
        map.put(1L,"zhangsan");
        map.put(2L,"lisi");
        map.put(3L,"wangwu");
    }

    public String queryUserName(Long uid) {
        return map.get(uid);
    }


}
