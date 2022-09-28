package com.example.ssm.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
@SuppressWarnings({"all"})

public class DruidUtils {
    private static DataSource dataSource;
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("D:\\Mycode\\project\\module\\qqzone\\src\\main\\java\\com\\example\\utils\\Druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection creaeteConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static Connection getConnection() throws SQLException {
        Connection conn = threadLocal.get();
        if (conn == null) {
            conn = creaeteConnection();
            threadLocal.set(conn);
        }
        return threadLocal.get();
    }

    public static void close(ResultSet resultSet, Statement statement, Connection connection){
        try {
            if(resultSet != null){
                resultSet.close();
            }
            if(statement != null){
                statement.close();
            }
//            if(connection != null){
//                connection.close();
//            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeConnection() throws SQLException {
        Connection conn = threadLocal.get();
        if(conn == null) {
            return;
        }
        if(!conn.isClosed()) {
            conn.close();
            threadLocal.set(null);
        }
    }
}
