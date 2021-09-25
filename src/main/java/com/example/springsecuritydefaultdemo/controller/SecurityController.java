package com.example.springsecuritydefaultdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @GetMapping("/secure/hello")
    public String hello(){
        return "Secure Hello";
    }

    @GetMapping("/public/hello")
    public String publicHello(){
        return "Secure Hello";
    }

}
