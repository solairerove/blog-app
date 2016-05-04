package com.github.union.blog;

import com.github.union.blog.domain.Person;
import com.github.union.blog.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static org.springframework.boot.SpringApplication.*;

/**
 * Created by union on 04.05.16.
 */

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(PersonRepository personRepository) {
        return args -> {
            personRepository.save(new Person("Jack", "Bauer"));
            personRepository.save(new Person("John", "Smith"));
            personRepository.save(new Person("James", "Bond"));
            personRepository.save(new Person("Tony", "Stark"));
            personRepository.save(new Person("Steve", "Lol"));
        };
    }
}