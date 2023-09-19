package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    private ICustomerService service;

    @GetMapping("")
    public String index(Model model) {
        List<Customer> customerList = service.findALl();
        model.addAttribute("customerList",customerList);
        return "index";
    }
}
