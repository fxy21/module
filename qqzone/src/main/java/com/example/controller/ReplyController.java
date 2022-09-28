package com.example.controller;

import com.example.domain.Reply;
import com.example.domain.Topic;
import com.example.domain.UserBasic;
import com.example.service.ReplyService;
import com.example.ssm.utils.DateUtils;

import javax.servlet.http.HttpSession;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
public class ReplyController {
    private ReplyService replyService = null;

    public String addReply(String content ,Integer topicId , HttpSession session ) throws Exception {
        UserBasic author = (UserBasic) session.getAttribute("userBasic");
        Reply reply = new Reply(content, DateUtils.getDateString(), author.getId(), author, topicId, new Topic(topicId));
        replyService.addReply(reply);
        return "redirect:topic.do?operate=topicDetail&id="+topicId;
    }

    public String delReply(Integer replyId , Integer topicId) throws Exception {
        System.out.println(replyId);
        replyService.delReply(replyId);
        return "redirect:topic.do?operate=topicDetail&id="+topicId;
    }
}






















