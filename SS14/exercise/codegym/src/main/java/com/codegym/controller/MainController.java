package com.codegym.controller;

import com.codegym.utilities.WebUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Welcome to our page");
        model.addAttribute("message", "This is welcome page");
        return "/index";
    }

    @GetMapping("/admin")
    public String adminPage(Model model, Principal principal) {
        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "/admin-page";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "/login-page";
    }

    @GetMapping("userInfo")
    public String userInfo(Model model, Principal principal) {
        //sau khi login thành công thì sẽ có đối tượng principal
        String username = principal.getName();

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "/user-info-page";
    }

    @GetMapping("/403")
    public String accessDenied(Model model, Principal principal) {
        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);
            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName()
                    + "</br> You do not have permission to access this page!";

            model.addAttribute("message", message);
        }
        return "/403-page";
    }
    @GetMapping("/logoutSuccessful")
    public String logoutSuccessful() {
        return "/logout-success-page";
    }
}
