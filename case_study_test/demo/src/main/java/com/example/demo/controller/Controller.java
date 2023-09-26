package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/about")
    public String about() {
        return "about";
    }
    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
    @GetMapping("/feature")
    public String feature() {
        return "feature";
    }

    @GetMapping("/404")
    public String errors() {
        return "404";
    }
}
