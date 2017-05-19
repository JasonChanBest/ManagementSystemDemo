package com.ms.core.servlet;

import com.ms.core.config.SpringConfig;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @author Jason
 * @since v1.0
 */
public class DispatcherServlet extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[0];
    }

    @Override
    protected String[] getServletMappings() {
        //只拦截.do请求，即Spring MVC的控制器只对应.do后缀的请求
        return new String[]{"*.do"};
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        //字符集过滤器，设置编码为UTF-8，防止出现代码
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8");
        servletContext.addFilter("characterEncodingFilter", characterEncodingFilter).addMappingForUrlPatterns(null, false, "/*");
    }
}
