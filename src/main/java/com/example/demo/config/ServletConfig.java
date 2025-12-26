package com.example.demo.config;

import com.example.demo.servlet.SimpleHealthServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean<SimpleHealthServlet> healthServlet() {
        return new ServletRegistrationBean<>(new SimpleHealthServlet(), "/health");
    }
}
