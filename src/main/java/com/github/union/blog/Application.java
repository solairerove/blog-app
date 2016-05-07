package com.github.union.blog;

import com.github.union.blog.domain.Post;
import com.github.union.blog.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
    public CommandLineRunner demo(PostRepository postRepository) {
        return args -> {
            postRepository.save(new Post("post1", "this is 1 post", "text1", LocalDate.now(), "author1"));
            postRepository.save(new Post("post2", "this is 2 post", "text2", LocalDate.now(), "author2"));
            postRepository.save(new Post("post3", "this is 3 post", "text3", LocalDate.now(), "author3"));
            postRepository.save(new Post("post4", "this is 4 post", "text4", LocalDate.now(), "author4"));
            postRepository.save(new Post("post5", "this is 5 post", "text5", LocalDate.now(), "author5"));
        };
    }
}