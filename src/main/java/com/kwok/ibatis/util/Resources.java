package com.kwok.ibatis.util;

import java.io.InputStream;

public class Resources {
    public static InputStream getResourceAsStream(String path){
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return classLoader.getResourceAsStream(path);
    }
}
