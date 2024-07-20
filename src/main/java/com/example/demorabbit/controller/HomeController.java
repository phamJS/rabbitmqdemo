package com.example.demorabbit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/show")
    public String show() {
        return "welcome to chien pham";
    }
}
