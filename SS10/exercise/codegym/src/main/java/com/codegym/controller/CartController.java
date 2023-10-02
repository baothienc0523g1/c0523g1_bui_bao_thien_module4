package com.codegym.controller;

import com.codegym.dto.CartDto;
import com.codegym.dto.ProductDto;
import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private IProductService productService;

    @GetMapping
    public String showCart(@SessionAttribute(value = "cart", required = false) CartDto cartDto,
                           Model model) {
        model.addAttribute("cartDto", cartDto);
        return "cart-list";
    }

    @GetMapping("/minus/{id}")
    public String minus(@SessionAttribute(value = "cart", required = false) CartDto cartDto,
                        @PathVariable Long id,
                        RedirectAttributes redirectAttributes) {
        Product product = this.productService.findById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        if (cartDto.getProducts().get(productDto) <= 1) {
            redirectAttributes.addFlashAttribute("message", "Hành động không hợp lệ");
        } else {
            cartDto.removeProduct(productDto);
        }
        return "redirect:/cart";
    }

    @GetMapping("/additional/{id}")
    public String additional(@SessionAttribute(value = "cart", required = false) CartDto cartDto,
                             @PathVariable Long id,
                             RedirectAttributes redirectAttributes) {
        Product product = this.productService.findById(id);
        if (product == null) {
            redirectAttributes.addFlashAttribute("message", "Sản phẩm vừa chọn không còn tồn tại" +
                    " trên hệ thống");
        } else {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            cartDto.addProduct(productDto);
        }
        return "redirect:/cart";
    }

}
