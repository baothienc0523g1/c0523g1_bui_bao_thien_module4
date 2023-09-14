package com.codegym.controller;

import com.codegym.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private IService service;

    @GetMapping("")
    public String showForm(Model model) {
        Map<String, String> vocabulary = this.service.showList();
        model.addAttribute("vocabulary", vocabulary);
        return "form";
    }

    @PostMapping("")
    public String translate(@RequestParam String keyWord, Model model) {
        Map<String, String> vocabulary = this.service.showList();
        String result = this.service.search(keyWord);
        model.addAttribute("result", result);
        model.addAttribute("keyWord", keyWord);
        model.addAttribute("vocabulary", vocabulary);
        return "form";
    }
}
