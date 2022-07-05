package com.spring.core.io;

import cn.hutool.core.lang.Assert;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author zhangqingyang
 * @date 2022-07-04-17:54
 */
public class DefaultResourceLoader implements ResourceLoader{
    @Override
    public Resource getResource(String location) {
        Assert.notNull(location,"location can not be null");
        if (location.startsWith(CLASSPATH_URL_PREFIX)){
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        }else {
            try {
                URL url = new URL(location);
                return new UrlResource(url);
            }catch (MalformedURLException e) {
                return new FileSystemResource(location);
            }
        }
    }
}
