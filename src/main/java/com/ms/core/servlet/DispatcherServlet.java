package com.ms.core.servlet;

import com.ms.core.config.SpringConfig;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.nio.charset.StandardCharsets;

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
        //ֻ����.do���󣬼�Spring MVC�Ŀ�����ֻ��Ӧ.do��׺������
        return new String[]{"*.do"};
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //�ַ��������������ñ���ΪUTF-8����ֹ���ִ���
        FilterRegistration.Dynamic dynamic = servletContext.addFilter("characterEncodingFilter", new CharacterEncodingFilter(StandardCharsets.UTF_8.name(), true));
        dynamic.addMappingForUrlPatterns(null, false, "/*");

        //�������һ��Ҫ�������ִ�У��������������CharacterEncodingFilter������ʧЧ
        super.onStartup(servletContext);
    }
}
