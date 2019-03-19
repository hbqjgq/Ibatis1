package com.kwok.ibatis.session;

import java.io.Closeable;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

public interface SqlSession extends Closeable {
    <T> T selectOne(String var1);

    <T> T selectOne(String var1, Object var2);

    <E> List<E> selectList(String var1);

    <E> List<E> selectList(String var1, Object var2);

//    <E> List<E> selectList(String var1, Object var2, RowBounds var3);

    <K, V> Map<K, V> selectMap(String var1, String var2);

    <K, V> Map<K, V> selectMap(String var1, Object var2, String var3);

//    <K, V> Map<K, V> selectMap(String var1, Object var2, String var3, RowBounds var4);

//    <T> Cursor<T> selectCursor(String var1);
//
//    <T> Cursor<T> selectCursor(String var1, Object var2);
//
//    <T> Cursor<T> selectCursor(String var1, Object var2, RowBounds var3);

//    void select(String var1, Object var2, ResultHandler var3);
//
//    void select(String var1, ResultHandler var2);
//
//    void select(String var1, Object var2, RowBounds var3, ResultHandler var4);

    int insert(String var1);

    int insert(String var1, Object var2);

    int update(String var1);

    int update(String var1, Object var2);

    int delete(String var1);

    int delete(String var1, Object var2);

    void commit();

    void commit(boolean var1);

    void rollback();

    void rollback(boolean var1);

//    List<BatchResult> flushStatements();

    void close();

    void clearCache();

//    Configuration getConfiguration();

    <T> T getMapper(Class<T> var1);

    Connection getConnection();
}
