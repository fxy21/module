package com.example.book.ssm.springmvc;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
public class ViewBaseServlet extends HttpServlet {
    private TemplateEngine templateEngine;
    @Override
    public void init() throws ServletException {
        //1.获取ServletContext对象
        ServletContext servletContext = this.getServletContext();

        //2.创建Thymeleaf解析器对象
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(servletContext);

        //3.给解析器对象设置参数
        templateResolver.setTemplateMode(TemplateMode.HTML);

        //4.设置前缀
        String viewPrefix = servletContext.getInitParameter("view-prefix");
        templateResolver.setPrefix(viewPrefix);

        //5.设置后缀
        String viewSuffix = servletContext.getInitParameter("view-suffix");
        templateResolver.setSuffix(viewSuffix);

        //6.设置缓存过期时间
        templateResolver.setCacheTTLMs(60000L);

        //7.设置是否缓存
        templateResolver.setCacheable(true);

        //8.设置服务器端编码方式
        templateResolver.setCharacterEncoding("utf-8");

        //9.创建模板引擎对象
        templateEngine = new TemplateEngine();

        //10.给模板引擎对象设置模板解析器
        templateEngine.setTemplateResolver(templateResolver);
    }

    protected void processTemplate(String templateName , HttpServletRequest request , HttpServletResponse response) throws IOException {
        //1.设置响应体的内容类型和字符集
        response.setContentType("text/html;charset=UTF-8");
        //2.创建WebContext对象
        WebContext webContext = new WebContext(request, response, getServletContext());
        //3.处理模板数据
        templateEngine.process(templateName , webContext , response.getWriter());
    }
}
