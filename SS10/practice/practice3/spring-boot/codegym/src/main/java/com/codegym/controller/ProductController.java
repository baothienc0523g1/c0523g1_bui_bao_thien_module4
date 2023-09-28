package com.codegym.controller;

import com.codegym.model.Cart;
import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/back")
    public String back() {
        return "redirect:/";
    }

    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable Long id,
                            @SessionAttribute(value = "cart", required = false) Cart cart,
                            Model model) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error-404";
        }
        Product product = this.productService.findById(id).get();
        cart.addProduct(product);
        int cartItems = cart.countItemQuantity();
        model.addAttribute("cartItems", cartItems);
        return "redirect:/shop";
    }

    //-------------add product-------------
    @GetMapping("/addProduct")
    public String showFormAddProduct(Model model) {
        model.addAttribute("product", new Product());
        return "/product-add";
    }

    @PostMapping("/addProduct")
    public String add(@ModelAttribute Product product,
                      RedirectAttributes redirectAttributes) {
        this.productService.addProduct(product);
        redirectAttributes.addFlashAttribute("message", "Add new product success!!");
        return "redirect:/";
    }
}
