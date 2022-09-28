package com.example.dao;

import com.example.domain.Reply;
import com.example.domain.Topic;
import com.example.ssm.basedao.BasicDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
public class ReplyDao extends BasicDao<Reply> {
    //获取指定日志的回复列表
    public List<Reply> getReplyList(Topic topic) throws Exception{
        String sql = "select * from t_reply where topic = ?";
        try {
            return querymulti(sql,Reply.class,topic.getId());
        } catch (SQLException e) {
            throw new RuntimeException("获取指定日志的回复列表失败");
        }
    }

    //添加回复
    public int addReply(Reply reply) throws Exception{
        String sql = "insert into t_reply values(0,?,?,?,?)";
        try {
            int i = dml(sql, reply.getContent(), reply.getReplyDate(), reply.getAuthor(), reply.getTopic());
            return i;
        } catch (SQLException e) {
            throw new RuntimeException("增加回复失败");
        }
    }

    //删除回复
    public int deleteReply(Integer id) throws Exception{
        String sql = "delete from t_reply where id = ?";
        try {
            return dml(sql, id);
        } catch (SQLException e) {
            throw new RuntimeException("删除回复失败");
        }
    }

    //根据Id获取指定的reply
    public Reply getReplyById(Integer id) throws Exception{
        String sql = "select * from t_reply where id = ?";
        try {
            return querysingle(sql, Reply.class, id);
        } catch (SQLException e) {
            throw new RuntimeException("获取reply失败");
        }
    }
}
