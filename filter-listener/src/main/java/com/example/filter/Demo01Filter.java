package com.example.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
//@WebFilter("/demo01.do")
public class Demo01Filter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截前");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("拦截后");
    }

    @Override
    public void destroy() {
        //Filter.super.destroy();
    }
}
