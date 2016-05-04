package com.github.union.blog.controller;

import com.github.union.blog.dto.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by union on 04.05.16.
 */

@RestController
@RequestMapping("/api")
public class GreetingController {
    private static final String TEMPLATE = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World", required = false) String name) {
        return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name));
    }
}