package com.example.service;

import com.example.dao.TopicDao;
import com.example.domain.Reply;
import com.example.domain.Topic;
import com.example.domain.UserBasic;

import java.util.ArrayList;
import java.util.List;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
public class TopicService {
    private TopicDao topicDao = null;
    private ReplyService replyService = null;
    private UserBasicService userBasicService = null;

    //查询特定用户的日志
    public List<Topic> getTopicList(UserBasic userBasic) throws Exception {
        return topicDao.getTopicList(userBasic);
    }

    //根据id获取指定的topic
    public Topic getTopicById(Integer id) throws Exception {
        Topic topic = topicDao.getTopic(id);
        List<Reply> getReplyList = replyService.getReplyListByTopicId(topic.getId());
        List<Reply> replyList = new ArrayList<>(getReplyList.size());
        for (int i = 0; i < getReplyList.size(); i++) {
            Reply reply = getReplyList.get(i);
            reply.setReplyAuthor(userBasicService.getUserBasicById(reply.getAuthor()));
            replyList.add(reply);
        }
        topic.setReplyList(replyList);
        UserBasic author = userBasicService.getUserBasicById(topic.getAuthor());
        topic.setTopicAuthor(author);
        return topic;
    }

    //删除特定的topic
    public void delTopic(Integer topicId) throws Exception {
        Topic topic = topicDao.getTopic(topicId);
        if(topic != null) {
            replyService.delReplyList(topic);
            topicDao.deleteTopic(topic);
        }
    }
}






















