package com.example.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Welcome to Frontend Application";
    }
    
    @GetMapping("/hello")
    public String hello() {
        return "Hello from Spring Boot!";
    }
}
