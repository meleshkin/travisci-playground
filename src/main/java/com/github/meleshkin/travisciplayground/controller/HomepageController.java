package com.github.meleshkin.travisciplayground.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomepageController {

    @RequestMapping("/")
    @ResponseBody
    String sayHello() {
        return "Welcome to Github -> Travis CI-> Heroku test page!<br>Have a nice day!";
    }
}
