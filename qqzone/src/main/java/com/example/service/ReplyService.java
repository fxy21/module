package com.example.service;

import com.example.dao.ReplyDao;
import com.example.domain.HostReply;
import com.example.domain.Reply;
import com.example.domain.Topic;

import java.util.List;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
public class ReplyService {
    private ReplyDao replyDao = null;
    private HostReplyService hostReplyService = null;

    //根据topic的id获取关联的所有回复
    public List<Reply> getReplyListByTopicId (Integer topicId) throws Exception {
        List<Reply> replyList = replyDao.getReplyList(new Topic(topicId));
        for (int i = 0; i < replyList.size(); i++) {
            Reply reply = replyList.get(i);
            HostReply hostReply = hostReplyService.getHostReplyById(reply.getId());
            reply.setHostReply(hostReply);
        }
        return replyList;
    }

    //添加回复
    public void addReply(Reply reply) throws Exception {
        replyDao.addReply(reply);
    }


    //删除指定回复
    public void delReply(Integer id) throws Exception {
        //1.根据Id获取指定的reply
        Reply reply = replyDao.getReplyById(id);
        if(reply != null) {
            //2.如果reply有关联的hostReply,则先删除hostReply
            HostReply hostReply = hostReplyService.getHostReplyById(reply.getId());
            if(hostReply != null) {
                hostReplyService.deleteReply(hostReply.getId());
            }
            //3.删除reply
            replyDao.deleteReply(id);
        }
    }


    //删除指定日志的关联的所有回复
    public void delReplyList(Topic topic) throws Exception {
        List<Reply> replyList = replyDao.getReplyList(topic);
        if(replyList != null) {
            for (Reply reply : replyList) {
                delReply(reply.getId());
            }
        }
    }
}
