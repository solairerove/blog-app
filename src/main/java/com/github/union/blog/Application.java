package com.github.union.blog;

import com.github.union.blog.domain.Person;
import com.github.union.blog.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import static org.springframework.boot.SpringApplication.*;

/**
 * Created by union on 04.05.16.
 */

@SpringBootApplication
@ComponentScan("com.github.union.blog.*")
public class Application {

    public static void main(String[] args) {
        run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(PersonRepository personRepository) {
        return args -> {
            personRepository.save(new Person("Jack", "Bauer"));
        };
    }
}
