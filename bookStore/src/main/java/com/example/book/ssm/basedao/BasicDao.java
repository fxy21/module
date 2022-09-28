package com.example.book.ssm.basedao;

import com.example.book.ssm.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
public class BasicDao<T> {
    private QueryRunner queryRunner = new QueryRunner();

    public int dml(String sql, Object... parameters ) throws SQLException {
        Connection connection;
            connection = DruidUtils.getConnection();
            int row = queryRunner.update(connection,sql,parameters);
            return row;
            //DruidUtils.close(null,null,connection);
    }
    public List<T> querymulti(String sql, Class<T> tClass, Object... parameters) throws SQLException {
        Connection connection;
        connection = DruidUtils.getConnection();
        return queryRunner.query(connection,sql,new BeanListHandler<T>(tClass),parameters);

        //DruidUtils.close(null,null,connection);

    }

    public T querysingle(String sql,Class<T> tClass,Object... parameters) throws SQLException {
        Connection connection;
        connection = DruidUtils.getConnection();
        return queryRunner.query(connection,sql,new BeanHandler<T>(tClass),parameters);
            //DruidUtils.close(null,null,connection);

    }

    public Object queryscalar(String sql,Object... parameters) throws SQLException {
        Connection connection = null;
        connection = DruidUtils.getConnection();
        return queryRunner.query(connection,sql,new ScalarHandler(),parameters);
           // DruidUtils.close(null,null,connection);

    }


}
