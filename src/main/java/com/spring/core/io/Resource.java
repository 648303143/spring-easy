package com.spring.core.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhangqingyang
 * @date 2022-07-04-17:51
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
