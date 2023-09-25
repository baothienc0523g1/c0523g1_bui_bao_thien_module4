package com.codegym.controller;

import com.codegym.dto.UserDto;
import com.codegym.model.User;
import com.codegym.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/")
    public String index(Model model) {
        List<User> users = this.userService.findAll();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/back")
    public String back() {
        return "redirect:/";
    }

    //    Add
    @GetMapping("/add")
    public String showAdd(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "add";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute UserDto userDto,
                      BindingResult bindingResult,
                      Model model) {
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "add";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        this.userService.add(user);
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        return "result";
    }
}
