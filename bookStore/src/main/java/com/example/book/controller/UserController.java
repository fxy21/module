package com.example.book.controller;

import com.example.book.domain.Cart;
import com.example.book.domain.User;
import com.example.book.service.CartItemService;
import com.example.book.service.UserService;
import com.google.code.kaptcha.servlet.KaptchaServlet;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
public class UserController {
    private UserService userService  = null;
    private CartItemService cartItemService = null;

    public String login(String uname , String pwd , HttpSession session) throws Exception {
        User user = userService.login(uname, pwd);
        if(user != null) {
            Cart cart = cartItemService.getCart(user);
            user.setCart(cart);
            session.setAttribute("currUser" , user);
            return "redirect:book.do";
        }
        return "user/login";
    }

    public String regist(String uname,String pwd,String email,String verifyCode,HttpSession session,HttpServletResponse resp)throws Exception{
        Object kaptchaCodeObj = session.getAttribute("KAPTCHA_SEEION_KEY");
        if(kaptchaCodeObj == null || !verifyCode.equals(kaptchaCodeObj)) {
            resp.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter out = resp.getWriter();
            out.println("<script language='javascript'>alert('验证码不正确');</script>");
            return "user/regist";
        } else {
            userService.regist(new User(uname,pwd,email,0));
        }
        return "user/login";
    }

    public String ckUname(String uname) throws Exception {
        User user = userService.getUser(uname);
        if(user != null) {
            return "json:{'uname':'1'}";
        } else {
            return "json:{'uname':'0'}";
        }
    }
}
