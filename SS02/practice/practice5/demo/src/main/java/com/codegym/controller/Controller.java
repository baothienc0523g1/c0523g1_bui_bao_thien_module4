package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("")
public class Controller {
    @Autowired
    private IService service;
    @GetMapping("")
    public ModelAndView findAll(Model model) {
        ModelAndView modelAndView = new ModelAndView("list");
        List<Customer> customerList = this.service.findAll();
        modelAndView.addObject("customerList",customerList);
        return modelAndView;
    }
    @GetMapping("/{id}")
    public ModelAndView showInformation(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("info");
        Customer customer = this.service.findById(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }
    @PostMapping
    public String updateCustomer(Customer customer) {
        this.service.save(customer);
        return "redirect:/customers";
    }
}
