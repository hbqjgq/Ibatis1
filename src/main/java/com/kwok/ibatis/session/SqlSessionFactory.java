package com.kwok.ibatis.session;

import com.kwok.ibatis.core.Configuration;

import java.sql.Connection;

public interface SqlSessionFactory {
    SqlSession openSession();

    SqlSession openSession(boolean var1);

    SqlSession openSession(Connection var1);

//    SqlSession openSession(TransactionIsolationLevel var1);
//
//    SqlSession openSession(ExecutorType var1);
//
//    SqlSession openSession(ExecutorType var1, boolean var2);
//
//    SqlSession openSession(ExecutorType var1, TransactionIsolationLevel var2);
//
//    SqlSession openSession(ExecutorType var1, Connection var2);

    Configuration getConfiguration();
}
