package com.github.solairerove.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by union on 01.06.16.
 */
@Controller
//TODO swagger io annotations fo doc
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homepage(){
        return "index.html";
    }
}
