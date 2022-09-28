package com.example.controller;

import com.example.domain.Topic;
import com.example.domain.UserBasic;
import com.example.service.TopicService;
import com.example.service.UserBasicService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
public class UserController {
    private UserBasicService userBasicService = null;
    private TopicService topicService = null;

    public String login(String loginId , String pwd , HttpSession session) throws Exception {
        //登录验证
        UserBasic userBasic = userBasicService.login(loginId, pwd);

        if (userBasic != null) {
            List<UserBasic> friendList = userBasicService.getFriendList(userBasic);
            List<Topic> topicList = topicService.getTopicList(userBasic);
            userBasic.setFriendList(friendList);
            userBasic.setTopicList(topicList);
            //userBasic保存的是登录者的信息
            //friend保存的是当前进入谁的空间
            session.setAttribute("userBasic" , userBasic);
            session.setAttribute("friend",userBasic);
            return "index";
        } else {
            return "login";
        }
    }

    //
    public String friend(Integer id , HttpSession session) throws Exception {
        //根据id获取指定用户信息
        UserBasic currentFriend = userBasicService.getUserBasicById(id);
        List<Topic> topicList = topicService.getTopicList(currentFriend);
        currentFriend.setTopicList(topicList);
        session.setAttribute("friend",currentFriend);
        return "index";

    }
}
