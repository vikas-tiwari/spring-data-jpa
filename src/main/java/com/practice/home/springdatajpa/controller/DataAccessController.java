package com.practice.home.springdatajpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataAccessController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
