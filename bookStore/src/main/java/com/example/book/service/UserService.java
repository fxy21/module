package com.example.book.service;

import com.example.book.dao.UserDao;
import com.example.book.domain.User;
import com.google.code.kaptcha.servlet.KaptchaServlet;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
public class UserService {
    private UserDao userDao = null;

    public User login(String uname , String pwd) throws Exception {
        return userDao.getUser(uname,pwd);
    }

    public void regist(User user) throws Exception {
        userDao.addUser(user);
    }

    public User getUser(String uname) throws Exception {
        return userDao.getUser(uname);
    }
}
