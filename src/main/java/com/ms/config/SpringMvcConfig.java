package com.ms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author Jason
 * @since v1.0
 */
@Configuration
@EnableWebMvc
@PropertySource("classpath:config.properties")
public class SpringMvcConfig extends WebMvcConfigurerAdapter {
    @Bean
    public ViewResolver viewResolver(@Value("${Prefix}") String prefix , @Value("${Suffix}") String suffix) {
        InternalResourceViewResolver vr = new InternalResourceViewResolver();
        vr.setPrefix(prefix);
        vr.setSuffix(suffix);
        return vr;
    }
}
