package org.example;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;


@Configuration
@ComponentScan({"org.example"})
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {

    private ApplicationContext applicationContext;

    @Autowired
    private ApplicationContext getApplicationContext () {
        return applicationContext;
    }

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver () {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }
    @Bean
    public DataSource getDataSource(){

        HikariDataSource ds = new HikariDataSource();
        ds.setMaximumPoolSize(20);
        ds.setDriverClassName("oracle.jdbc.OracleDriver");
        ds.setJdbcUrl("jdbc:oracle:thin:@//localhost:1521/XEPDB1");
        ds.setUsername("nitro");
        ds.setPassword("753951852456");
        return ds;
    }

    @Override
    public void addResourceHandlers (ResourceHandlerRegistry registry ) {
        registry
                .addResourceHandler("/styles/**")
                .addResourceLocations("/styles/");
    }


}
