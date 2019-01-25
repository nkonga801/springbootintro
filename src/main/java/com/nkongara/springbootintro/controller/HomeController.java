package com.nkongara.springbootintro.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    public String getEnvironment() {
        return environment;
    }

    @Value("${spring.profiles.active}")
    private String environment;

    @RequestMapping("/")
    public String WelcomeHome () {
        return  "Welcome to Home!";
    }

    @RequestMapping("/env")
    public String env(){
        return getEnvironment();
    }
}
