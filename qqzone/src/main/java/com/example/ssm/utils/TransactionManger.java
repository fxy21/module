package com.example.ssm.utils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
public class TransactionManger {

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    //开启事务
    public static void beginTrans() throws SQLException {
        DruidUtils.getConnection().setAutoCommit(false);
    }

    //提交事务
    public static void commit() throws SQLException {
        DruidUtils.getConnection().commit();
        DruidUtils.closeConnection();
    }

    //回滚事务
    public static void rollback() throws SQLException {
        DruidUtils.getConnection().rollback();
        DruidUtils.closeConnection();
    }
}
