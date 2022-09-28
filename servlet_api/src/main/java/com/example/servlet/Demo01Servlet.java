package com.example.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
@WebServlet(urlPatterns = {"/demo01.do"} ,
    initParams = {
        @WebInitParam(name = "name" , value = "哈兰德")
    })
public class Demo01Servlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        ServletConfig config = getServletConfig();
        String initValue = config.getInitParameter("name");
        System.out.println("initValue = " + initValue);

        ServletContext servletContext = getServletContext();
        String configLocation = servletContext.getInitParameter("contextConfigLocation");
        System.out.println("contextConfigLocation = " + configLocation);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //方法一
        ServletContext context = req.getServletContext();
        String contextConfigLocation = context.getInitParameter("contextConfigLocation");

        //方法二
        ServletContext context1 = req.getSession().getServletContext();
        String contextConfigLocation1 = context1.getInitParameter("contextConfigLocation");
    }
}
