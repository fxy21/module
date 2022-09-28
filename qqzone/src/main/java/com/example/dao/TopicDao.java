package com.example.dao;

import com.example.domain.Topic;
import com.example.domain.UserBasic;
import com.example.ssm.basedao.BasicDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
public class TopicDao extends BasicDao<Topic> {
    //获取指定用户的所有日志
    public List<Topic> getTopicList(UserBasic userBasic) throws Exception{
        String sql = "select * from t_topic where author = ?";
        try {
            return querymulti(sql,Topic.class,userBasic.getId());
        } catch (SQLException e) {
            throw new RuntimeException("获取用户日志失败");
        }
    }

    //添加日志
    public void addTopic(Topic topic) throws Exception{
        String sql = "insert into t_topic values()";
    }

    //删除日志
    public void deleteTopic(Topic topic) throws Exception{
        String sql = "delete from t_topic where id = ?";
        dml(sql,topic.getId());
    }

    //获取指定日志信息
    public Topic getTopic(Integer id) throws Exception{
        String sql = "select * from t_topic where id = ?";
        try {
            return querysingle(sql,Topic.class,id);
        } catch (SQLException e) {
            throw new RuntimeException("获取指定日志信息失败");
        }
    }
}
