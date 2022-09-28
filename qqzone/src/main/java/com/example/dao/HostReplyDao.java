package com.example.dao;

import com.example.domain.HostReply;
import com.example.ssm.basedao.BasicDao;

import java.sql.SQLException;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
public class HostReplyDao extends BasicDao<HostReply> {

    //根据replyId查询查询相关联的HostReply实体
    public HostReply getHostReplyByReplyId(Integer replyId) throws Exception{
        String sql = "select * from t_host_reply where reply = ?";
        try {
            return querysingle(sql,HostReply.class,replyId);
        } catch (SQLException e) {
            throw new RuntimeException("查询主人回复失败");
        }
    }

    //删除特定的hostReply
    public void deleteHostReply(Integer id) throws Exception{
        String sql = "delete from t_host_reply where id = ?";
        try {
            dml(sql, id);
        } catch (SQLException e) {
            throw new RuntimeException("删除主人回复失败");
        }
    }
}
