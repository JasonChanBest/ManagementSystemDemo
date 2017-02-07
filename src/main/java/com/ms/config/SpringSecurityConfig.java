package com.ms.config;

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
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.securityInterceptor(getApplicationContext().getBean(FilterSecurityInterceptor.class));
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
            .loginPage("/user/loginInit.do")//登陆页面
            .loginProcessingUrl("/user/login.do")//登陆处理，只需配置一个路径，逻辑不用写，由spring security自动处理
            .usernameParameter("name")//登陆名参数名
            .passwordParameter("password")//密码参数名
            .successForwardUrl("/index.do")//登陆成功后返回页面
            .failureForwardUrl("/404.jsp")//登陆失败后返回页面
            .and()
            .authorizeRequests()
            .antMatchers("/**.do")//首先对.do请求进行权限认证拦截
            .authenticated()
            .antMatchers("/user/loginInit.do")//对于登陆页面请求直接放行
            .permitAll()
            .anyRequest()//其他资源的访问直接放行，如图片、js文件、css文件等
            .permitAll();
    }
}
