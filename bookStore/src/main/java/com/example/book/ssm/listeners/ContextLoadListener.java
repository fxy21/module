package com.example.book.ssm.listeners;

import com.example.book.ssm.ioc.BeanFactory;
import com.example.book.ssm.ioc.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
@WebListener
public class ContextLoadListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //1.获取Servlet对象
        ServletContext application = sce.getServletContext();
        //2.获取上下文初始化参数
        String path = application.getInitParameter("contextConfigLocation");
        //3.创建IOC容器
        BeanFactory beanFactory = new ClassPathXmlApplicationContext();
        //4.将IOC容器保存到application作用域
        application.setAttribute("beanFactory" , beanFactory);

    }
}
