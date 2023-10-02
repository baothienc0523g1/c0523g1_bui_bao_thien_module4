package com.codegym.controller;

import com.codegym.dto.CartDto;
import com.codegym.dto.ProductDto;
import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public CartDto initCartDto() {
        return new CartDto();
    }

    // trang chủ + back
    @GetMapping
    public String index(Model model) {
        List<Product> products = this.productService.findAll();
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/back")
    public String back() {
        return "redirect:/";
    }

    //add product
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

    //product detail
    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable long id,
                               HttpServletResponse response,
                               Model model) {
        Cookie cookie = new Cookie("productId", id + "");
        cookie.setMaxAge(60 * 60 * 24);
        cookie.setPath("/");
        response.addCookie(cookie);
        ModelAndView modelAndView = new ModelAndView("detail", "lastProduct", this.productService.findById(id));
        return modelAndView;
    }

    //add new cart
    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable Long id,
                            @SessionAttribute(value = "cart", required = false) CartDto cartDto,
                            Model model,
                            RedirectAttributes redirectAttributes) {
        try {
            Product product = this.productService.findById(id);
            if (product != null) {
                ProductDto productDto = new ProductDto();
                BeanUtils.copyProperties(product, productDto);
                cartDto.addProduct(productDto);
                int itemQuantity = cartDto.countProductQuantity();
                model.addAttribute("itemQuantity", itemQuantity);
                redirectAttributes.addFlashAttribute("message", "Thêm thành công sản phẩm "
                        + productDto.getName() + " vào giỏ hàng");
            } else {
                redirectAttributes.addFlashAttribute("message", "Xin lỗi vì sự bất tiện này. " +
                        "Sản phẩm bạn vừa chọn không còn tồn tại trên hệ thống, vui chọn chọn sản phẩm khác!!");
            }
        } catch (NullPointerException npe) {
            System.out.println(npe.getMessage());
            redirectAttributes.addFlashAttribute("message","Lỗi mạng");
        } finally {
            return "redirect:/";
        }
    }
}
