package com.example.book.ssm.filters;

import com.example.book.ssm.utils.TransactionManger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
@WebFilter("*.do")
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
