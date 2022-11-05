package com.example.qa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class HelloController {

    @GetMapping
    public String showWelcomeMessage() {
        return "Welcome to question and answer application backend!";
    }
}
