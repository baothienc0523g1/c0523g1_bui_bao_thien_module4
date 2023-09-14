package com.codegym.controller;

import com.codegym.service.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private Convert convert;

    @GetMapping("")
    public String showForm() {
        return "convert";
    }
    @PostMapping("convert/do-convert")
    public String convert(@RequestParam double usd, Model model) {
        double result = convert.convert(usd);
        model.addAttribute("result", result);
        model.addAttribute("VND", " .VND");
        return "convert";
    }

}
