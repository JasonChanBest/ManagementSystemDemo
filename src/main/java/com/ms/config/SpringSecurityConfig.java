package com.ms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * spring security主要做两件事情：
 * 1、认证，即用户登陆
 * 2、授权，即访问受到权限保护的url、方法等
 *
 * @author Jason
 * @since v1.0
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private FilterSecurityInterceptor filterSecurityInterceptor;

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public FilterSecurityInterceptor filterSecurityInterceptor(AccessDecisionManager adm , FilterInvocationSecurityMetadataSource fisms) {
        FilterSecurityInterceptor fsi = new FilterSecurityInterceptor();
        fsi.setSecurityMetadataSource(fisms);
        fsi.setAccessDecisionManager(adm);
        return fsi;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //js、css、jsp、图片等资源不拦截
        web
                .ignoring()
                .antMatchers("/**.js", "/**.css", "/**.jpg", "/**.png", "/**.ico", "/**.jsp")
                .and()
                //配置FilterSecurityInterceptor拦截器，
                // 这个拦截器注入了我们自己实现的CustomSecurityMetadataSource和CustomAccessDecisionManager
                //CustomSecurityMetadataSource会根据当前访问的url从数据库中找出访问这个url所需要的用户角色，
                //而CustomAccessDecisionManager则会根据当前登陆的用户所拥有的角色判断这个用户能不能访问这个url
                .securityInterceptor(filterSecurityInterceptor);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /**
         * 这里配置自己实现的UserDetailsService，
         * 在登陆时spring security会根据用户名、密码从这个UserDetailsService中获取UserDetails，
         * 有就登陆成功，没有就登陆失败
         */
        auth.userDetailsService(userDetailsService);
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/user/loginInit.do")
                .anonymous()//登陆页面可以匿名访问

                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()//所有访问请求都必须经过用户认证才能访问

                .and()
                .formLogin()
                .loginPage("/user/loginInit.do") //登陆页面
                .loginProcessingUrl("/user/login.do")//登陆处理，只需配置一个路径，逻辑不用写，由spring security自动处理
                .usernameParameter("name")//登陆名参数名
                .passwordParameter("password")//密码参数名
                .successForwardUrl("/index.do")//登陆成功后返回页面
                .failureForwardUrl("/404.jsp")//登陆失败后返回页面

                .and()
                .logout()
                .logoutUrl("/user/logout.do")//退出处理，只需要配置一个路径，逻辑不用写，由spring security自动处理
                .logoutSuccessUrl("/user/loginInit.do")//退出成功返回登陆页面

                .and()
                .sessionManagement()
                .invalidSessionUrl("/user/loginInit.do")//session过期时返回登陆页面，要求重新登陆

                .and()
                .rememberMe();//记住密码功能，登陆表单jsp需要加入<input type="checkbox" name="remember-me">
    }
}
