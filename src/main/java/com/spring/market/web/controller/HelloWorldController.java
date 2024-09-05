package com.spring.market.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sayHello")
public class HelloWorldController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello world 🌐";
    }
}
