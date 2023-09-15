package com.codegym.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@org.springframework.stereotype.Controller
public class EmailController {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static Pattern pattern;

    public EmailController() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }
    @GetMapping("")
    public String home() {
        return "home";
    }
    private boolean isValid(String regex) {
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    @PostMapping("validate")
    public String user(@RequestParam("email") String email, ModelMap modelMap) {
        boolean isValid = this.isValid(email);
        if (!isValid) {
            modelMap.addAttribute("message", "Email is invalid");
            return "home";
        }
        modelMap.addAttribute("email",email);
        return "success";
    }

}
