package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService service;

    @GetMapping("")
    public String index(Model model) {
        List<Product> products = this.service.findAll();
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("show-update/{id}")
    public String showUpdateForm(Model model, @PathVariable int id,
                                 @ModelAttribute Product product) {
        Product productExist = this.service.findById(id);
        model.addAttribute("id", id);
        model.addAttribute("productExist", productExist);
        model.addAttribute("product", product);
        return "update";
    }

    @PostMapping("update")
    public String update(@RequestParam int id,
                         @ModelAttribute Product product) {
        this.service.update(id, product);
        return "redirect:/";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id) {
        this.service.delete(id);
        return "redirect:/";
    }

    @GetMapping("add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        return "add";
    }

    @GetMapping("back")
    public String back() {
        return "redirect:/";
    }

    @PostMapping("save")
    public String save(@ModelAttribute Product product) {
        this.service.create(product);
        return "redirect:/";
    }

    @GetMapping("search")
    public String search(@RequestParam String name, Model model) {
        List<Product> products = this.service.findByName(name);
        model.addAttribute("products", products);
        return "search-result";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        Product product = this.service.findById(id);
        model.addAttribute("product", product);
        return "detail";
    }
}
