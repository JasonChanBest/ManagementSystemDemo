package com.ms.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author Jason
 * @since v1.0
 */
@Configuration
@PropertySource("classpath:config.properties")
@EnableWebMvc
@EnableJpaRepositories(basePackages = "com.ms.dao")
@ComponentScan(basePackages = "com.ms")
public class SpringConfig {

    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public ViewResolver viewResolver(@Value("${prefix}") String prefix ,@Value("${suffix}") String suffix) {
        InternalResourceViewResolver vr = new InternalResourceViewResolver();
        vr.setPrefix(prefix);
        vr.setSuffix(suffix);
        return vr;
    }

    @Bean
    public DataSource dataSource(@Value("${DriverClass}") String driverClass , @Value("${User}") String user , @Value("${Password}") String password , @Value("${JdbcUrl}") String jdbcUrl) throws PropertyVetoException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass(driverClass);
        ds.setUser(user);
        ds.setPassword(password);
        ds.setJdbcUrl(jdbcUrl);
        return ds;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hjva = new HibernateJpaVendorAdapter();
        hjva.setGenerateDdl(true);
        hjva.setDatabase(Database.MYSQL);
        hjva.setShowSql(true);
        return hjva;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource , JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setJpaVendorAdapter(jpaVendorAdapter);
        emf.setPackagesToScan("com.ms.entity");
        return emf;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager jtm = new JpaTransactionManager();
        jtm.setEntityManagerFactory(entityManagerFactory);
        return jtm;
    }

    @Bean
    public FilterSecurityInterceptor filterSecurityInterceptor(AccessDecisionManager adm , FilterInvocationSecurityMetadataSource fisms) {
        FilterSecurityInterceptor fsi = new FilterSecurityInterceptor();
        fsi.setSecurityMetadataSource(fisms);
        fsi.setAccessDecisionManager(adm);
        return fsi;
    }

}
