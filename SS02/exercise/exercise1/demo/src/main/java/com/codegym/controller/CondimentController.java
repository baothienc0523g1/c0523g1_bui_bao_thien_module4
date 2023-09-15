package com.codegym.controller;

import com.codegym.service.ICondimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class CondimentController {
    @Autowired
    private ICondimentService service;
    @GetMapping("")
    public String showForm() {
        return "index";
    }
    @PostMapping("/save")
    public String save(@RequestParam("condiment") String[] condiment,
                                     Model model) {
        this.service.save(condiment);
        model.addAttribute("list",this.service.findAll());
        return "list";
    }
    @GetMapping("/save/back")
    public String backToForm(Model model) {
        return "index";
    }
}
