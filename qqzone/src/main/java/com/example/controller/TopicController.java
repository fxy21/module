package com.example.controller;

import com.example.domain.Topic;
import com.example.domain.UserBasic;
import com.example.service.TopicService;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * @彭新宇出品
 * @please respect copyringht
 */
public class TopicController {
    private TopicService topicService = null;

    public String topicDetail(Integer id , HttpSession session) throws Exception {
        Topic topic = topicService.getTopicById(id);
        session.setAttribute("topic" , topic);
        return "frames/detail";
    }

    public String delTopic(Integer topicId) throws Exception {
        topicService.delTopic(topicId);
        return "redirect:topic.do?operate=getTopicList";
    }

    public String getTopicList(HttpSession session) throws Exception {
        //从session中获取当前用户信息
        UserBasic userBasic = (UserBasic)session.getAttribute("userBasic");
        //再次查当前用户关联的所有日志
        List<Topic> topicList = topicService.getTopicList(userBasic);
        //设置关联日志列表，矫正session中关联的friend的topicList和此时数据库中的不一致
        userBasic.setTopicList(topicList);
        //重新覆盖friend的数据
        session.setAttribute("friend",userBasic);
        return "frames/main";
    }
}
