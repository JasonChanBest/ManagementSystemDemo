package com.ms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * @author Jason
 * @since v1.0
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private FilterSecurityInterceptor filterSecurityInterceptor;

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web.securityInterceptor(filterSecurityInterceptor);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);

        http.formLogin()
                .loginPage("/user/loginInit.do")
                .loginProcessingUrl("/user/login.do")
                .usernameParameter("name")
                .passwordParameter("password")
                .successForwardUrl("/index.do")
                .failureForwardUrl("/404.jsp");
    }
}
