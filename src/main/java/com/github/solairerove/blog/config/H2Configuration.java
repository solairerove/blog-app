package com.github.solairerove.blog.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by union on 12/06/16.
 */
@Configuration
public class H2Configuration {

    @Bean
    public ServletRegistrationBean h2servletRegistration() {
        WebServlet webServlet = new WebServlet();
        ServletRegistrationBean bean = new ServletRegistrationBean(webServlet);
        bean.addUrlMappings("/h2console/*");
        return bean;
    }
}
