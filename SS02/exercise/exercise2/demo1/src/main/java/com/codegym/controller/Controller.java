package com.codegym.controller;

import com.codegym.service.ICalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private ICalculator calculator;

    @GetMapping("")
    public String showForm() {
        return "index";
    }

    @PostMapping("/calculating")
    public String sendResult(@RequestParam(name = "firstOperator") long firstOperator,
                             @RequestParam(name = "secondOperator") long secondOperator,
                             @RequestParam(name = "submitNumber") int submitNumber,
                             Model model) {
        Long result = null;
        String notice = "";
        switch (submitNumber) {
            case 1:
                result = this.calculator.plusResolver(firstOperator, secondOperator);
                break;
            case 2:
                result = this.calculator.minusResolver(firstOperator, secondOperator);
                break;
            case 3:
                result = this.calculator.multiResolver(firstOperator, secondOperator);
                break;
            case 4:
                switch ((int) secondOperator) {
                    case 0:
                        notice = "Cant divide to zero bro";
                        break;
                    default:
                        result = this.calculator.divideResolver(firstOperator, secondOperator);
                        break;
                }

        }

        model.addAttribute("notice", notice);
        model.addAttribute("firstOperator", firstOperator);
        model.addAttribute("secondOperator", secondOperator);
        model.addAttribute("result", result);
        return "index";
    }
}
