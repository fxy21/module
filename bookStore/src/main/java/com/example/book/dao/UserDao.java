package com.example.book.dao;

import com.example.book.domain.User;
import com.example.book.ssm.basedao.BasicDao;

import java.sql.SQLException;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
public class UserDao extends BasicDao<User> {
    public User getUser(String uname , String pwd) throws Exception{
        String sql = "select * from t_user where uname like ? and pwd like ?";
        try {
            return querysingle(sql, User.class, uname, pwd);
        } catch (SQLException e) {
            throw new RuntimeException("查询用户失败");
        }
    }

    public void addUser(User user) throws Exception {
        String sql = "insert into t_user values(0,?,?,?,0)";
        try {
            dml(sql,user.getUname(),user.getPwd(),user.getEmail());
        } catch (SQLException e) {
            throw new RuntimeException("添加用户失败");
        }
    }

    public User getUser(String uname) throws Exception{
        String sql = "select * from t_user where uname = ?";
        try {
            return querysingle(sql , User.class , uname);
        } catch (SQLException e) {
            throw new RuntimeException("获取用户失败");
        }
    }
}
