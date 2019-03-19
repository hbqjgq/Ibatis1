package com.kwok.ibatis.session;

import com.kwok.ibatis.core.Configuration;

import java.sql.Connection;

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration configuration;

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    public SqlSession openSession() {
        return null;
    }

    public SqlSession openSession(boolean var1) {
        return null;
    }

    public SqlSession openSession(Connection var1) {
        return null;
    }

    public Configuration getConfiguration() {
        return this.configuration;
    }
}
