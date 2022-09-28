package com.example.dao;

import com.example.domain.UserBasic;
import com.example.ssm.basedao.BasicDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
public class UserBasicDao extends BasicDao<UserBasic> {
    //根据账号和密码获取特定的用户信息
    public UserBasic getUserBasic(String loginId , String pwd) throws Exception{
        String sql = "select * from t_user_basic where loginId = ? and pwd = ?";
        try {
            return querysingle(sql, UserBasic.class , loginId , pwd);
        } catch (SQLException e) {
            throw new RuntimeException("获取用户信息失败");
        }
    }

    //获取指定用户的所有好友列表
    public List<UserBasic> getUserBasicList(UserBasic userBasic) throws Exception{
        //必须给fid取一个别名，不然在domain中没有fid属性
        String sql = "select fid as 'id' from t_friend where uid = ?";
        try {
            return querymulti(sql,UserBasic.class,userBasic.getId());
        } catch (SQLException e) {
            throw new RuntimeException("获取好友列表失败");
        }
    }

    //根据Id查询用户信息
    public UserBasic getUserBasicById(Integer id) throws Exception{
        String sql = "select * from t_user_basic where id = ?";
        try {
            return querysingle(sql,UserBasic.class,id);
        } catch (SQLException e) {
            throw new RuntimeException("根据id获取用户信息失败");
        }
    }


}
