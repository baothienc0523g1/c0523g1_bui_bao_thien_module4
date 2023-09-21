package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping("")
    public String index(Model model) {
        List<Customer> customers = this.customerService.findAll();
        model.addAttribute("customers",customers);
        return "index";
    }
    //create
    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }
    @PostMapping("create")
    public String create(Customer customer) {
        this.customerService.save(customer);
        return "redirect:/";
    }
    //edit
    @GetMapping("edit/{id}")
    public String edit(Model model, @PathVariable int id) {
        Customer customer = this.customerService.findById(id);
        model.addAttribute("customer",customer);
        return "edit";
    }
    @PostMapping("edit")
    public String edit(Customer customer) {
        customerService.save(customer);
        return "redirect:/";
    }
    //delete
    @GetMapping("remove/{id}")
    public String delete(@PathVariable int id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "delete";
    }
    @PostMapping("remove")
    public String delete(Customer customer,
                         RedirectAttributes redirectAttributes) {
        this.customerService.remove(customer.getId());
        redirectAttributes.addFlashAttribute("success", "Removed customer");
        return "redirect:/";
    }
    @GetMapping("view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/view";
    }
}
