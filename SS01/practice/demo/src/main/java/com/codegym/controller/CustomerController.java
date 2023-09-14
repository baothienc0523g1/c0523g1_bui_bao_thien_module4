package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private IService service;
    @GetMapping("/customers")
    public ModelAndView showList(Model model) {
        ModelAndView modelAndView = new ModelAndView("list");
        List<Customer> list = service.showList();
        model.addAttribute("list", list);
        return modelAndView;
    }
}
