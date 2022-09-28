package com.example.service;

import com.example.dao.UserBasicDao;
import com.example.domain.UserBasic;

import java.util.ArrayList;
import java.util.List;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
public class UserBasicService {
    private UserBasicDao userBasicDao = null;

    //登录获取用户信息
    public UserBasic login(String loginId , String pwd) throws Exception {
        return userBasicDao.getUserBasic(loginId, pwd);
    }

    //获取好友列表
    public List<UserBasic> getFriendList(UserBasic userBasic) throws Exception {
        List<UserBasic> userBasicList = userBasicDao.getUserBasicList(userBasic);
        List<UserBasic> friendList = new ArrayList<>(userBasicList.size());
        for (int i = 0; i < userBasicList.size(); i++) {
            UserBasic friend = userBasicList.get(i);
            friend = userBasicDao.getUserBasicById(friend.getId());
            friendList.add(friend);
        }
        return friendList;
    }

    //根据id获取指定的用户信息
    public UserBasic getUserBasicById(Integer id) throws Exception {
        return userBasicDao.getUserBasicById(id);
    }
}
