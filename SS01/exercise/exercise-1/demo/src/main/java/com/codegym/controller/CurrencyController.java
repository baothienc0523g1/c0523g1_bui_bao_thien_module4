package com.codegym.controller;

import com.codegym.service.ICurrencyConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class CurrencyController {
    @Autowired
    private ICurrencyConverter converter;

    @GetMapping("")
    public String showForm() {
        return "index";
    }
    @PostMapping("do-convert")
    public String convert(@RequestParam double usd, Model model) {
        double result = converter.currencyConverter(usd);
        model.addAttribute("result", result);
        model.addAttribute("VND", " .VND");
        return "index";
    }

}
