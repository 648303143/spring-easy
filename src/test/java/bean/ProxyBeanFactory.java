package bean;

import com.spring.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;


/**
 * @author zhangqingyang
 * @date 2022-07-07-11:55
 */
public class ProxyBeanFactory implements FactoryBean<IUserDAO> {
    @Override
    public IUserDAO getObject() throws Exception {
        InvocationHandler handler = (proxy, method, args) -> {
            Map<String, String> map = new HashMap<>();
            map.put("10001", "令狐冲");
            map.put("10002", "岳不群");
            map.put("10003", "林平之");

            return "你被代理了 " + method.getName() + "：" + map.get(args[0].toString());
        };

        return (IUserDAO) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{IUserDAO.class}, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return IUserDAO.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
