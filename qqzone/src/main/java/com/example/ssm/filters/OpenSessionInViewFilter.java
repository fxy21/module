package com.example.ssm.filters;

import com.example.ssm.utils.TransactionManger;

import javax.servlet.*;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
public class OpenSessionInViewFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            TransactionManger.beginTrans();
            filterChain.doFilter(servletRequest,servletResponse);
            TransactionManger.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                TransactionManger.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void destroy() {

    }
}
