package com.example.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
@WebFilter("/demo02.do")
public class Filter03 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截C1");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("拦截C2");
    }

    @Override
    public void destroy() {
        //Filter.super.destroy();
    }
}
