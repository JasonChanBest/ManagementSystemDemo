package com.ms.filter;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

import javax.servlet.annotation.WebFilter;

/**
 * @author Jason
 * @since v1.0
 */
@WebFilter(urlPatterns = "*.do")
public class CustomSiteMeshFilter extends ConfigurableSiteMeshFilter {
    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder.addDecoratorPath("/*.do" , "/WEB-INF/baseFrame.jsp");
        builder.addExcludedPath("/user/loginInit.do");
    }
}
