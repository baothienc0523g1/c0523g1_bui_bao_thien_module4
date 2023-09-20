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
    private IProductService productService;

    //main page
    @GetMapping("")
    public String index(Model model) {
        List<Product> products = this.productService.showList();
        model.addAttribute("products", products);
        return "index";
    }

    //add
    @GetMapping("/add-product")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        return "add";
    }

    @PostMapping("add")
    public String add(@ModelAttribute Product product) {
        this.productService.addProduct(product);
        return "redirect:/";
    }

    //back
    @GetMapping("/back")
    public String back() {
        return "redirect:/";
    }

    //delete
    @PostMapping("/delete")
    public String delete(@RequestParam int id) {
        this.productService.removeProduct(id);
        return "redirect:/";
    }

    //update
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        Product product = this.productService.findById(id);
        model.addAttribute("product", product);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product) {
        this.productService.adjustProduct(product.getId(), product);
        return "redirect:/";
    }

    //detail
    @PostMapping("/detail")
    public String detail(@RequestParam int id, Model model) {
        Product product = this.productService.findById(id);
        model.addAttribute("product",product);
        return "detail";
    }
    //find by name
    @PostMapping ("/search")
    public String findByName(Model model, @RequestParam String name) {
        List<Product> resultList = this.productService.findByName(name);
        model.addAttribute("list",resultList);
        model.addAttribute("name",name);
        return "find-result";
    }
}
