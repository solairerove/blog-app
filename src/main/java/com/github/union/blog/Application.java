package com.github.union.blog;

import com.github.union.blog.domain.Post;
import com.github.union.blog.repository.PostRepository;
import org.h2.server.web.WebServlet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

import static org.springframework.boot.SpringApplication.run;

/**
 * Created by union on 04.05.16.
 */

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        run(Application.class, args);
    }

    @Bean
    public ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
        registration.addUrlMappings("/console/*");
        return registration;
    }
}