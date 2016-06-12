package com.github.solairerove.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by union on 04.05.16.
 */
@SpringBootApplication
@ComponentScan("com.github.solairerove.blog")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
