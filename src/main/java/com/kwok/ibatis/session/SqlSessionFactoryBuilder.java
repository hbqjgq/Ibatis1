package com.kwok.ibatis.session;

import com.kwok.ibatis.core.Configuration;
import com.kwok.ibatis.core.XmlConfigBuilder;

import java.io.InputStream;

public class SqlSessionFactoryBuilder {

    public  SqlSessionFactory build(InputStream inputStream){
        //解析xml配置
        XmlConfigBuilder xmlConfigBuilder = new XmlConfigBuilder(inputStream);
        build(xmlConfigBuilder.parse());
        return build(xmlConfigBuilder.parse());
    }

    public  SqlSessionFactory build(Configuration configuration){
        return new DefaultSqlSessionFactory(configuration);
    }
}
