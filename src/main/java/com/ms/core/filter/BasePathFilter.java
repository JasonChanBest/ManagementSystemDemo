package com.ms.core.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Jason
 * @since v1.0
 */
@WebFilter(urlPatterns = "*.do")
public class BasePathFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest r = (HttpServletRequest) request;
        HttpSession session = r.getSession();
        Object path = session.getAttribute("path");
        if(path == null) {
            path = r.getScheme() + "://" + r.getServerName() + ":" + r.getServerPort() + r.getContextPath();
            session.setAttribute("path", path);
        }
        chain.doFilter(request , response);
    }

    @Override
    public void destroy() {

    }
}
