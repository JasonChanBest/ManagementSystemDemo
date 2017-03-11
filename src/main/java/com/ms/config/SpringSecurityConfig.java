package com.ms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import java.util.ArrayList;

/**
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
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        ArrayList<AuthenticationProvider> providers = new ArrayList<>();
        providers.add(provider);
        return new ProviderManager(providers);
    }

    @Bean
    public FilterSecurityInterceptor filterSecurityInterceptor(AccessDecisionManager adm , FilterInvocationSecurityMetadataSource fisms , AuthenticationManager am) {
        FilterSecurityInterceptor fsi = new FilterSecurityInterceptor();
        fsi.setSecurityMetadataSource(fisms);
        fsi.setAccessDecisionManager(adm);
        fsi.setAuthenticationManager(am);
        return fsi;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/user/loginInit.do", "/resources", "/**.ico", "/**.jsp");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/user/loginInit.do")//登陆页面
                .loginProcessingUrl("/user/login.do")//登陆处理，只需配置一个路径，逻辑不用写，由spring security自动处理
                .usernameParameter("name")//登陆名参数名
                .passwordParameter("password")//密码参数名
                .successForwardUrl("/index.do")//登陆成功后返回页面
                .failureForwardUrl("/404.jsp")//登陆失败后返回页面

                .and()
                .logout()
                .logoutUrl("/user/logout.do")
                .logoutSuccessUrl("/user/loginInit.do")

                .and()
                .sessionManagement()
                .invalidSessionUrl("/user/loginInit.do")

                .and()
                .rememberMe()

                .and()
                .csrf()

                .and()
                .addFilter(filterSecurityInterceptor);
    }
}
