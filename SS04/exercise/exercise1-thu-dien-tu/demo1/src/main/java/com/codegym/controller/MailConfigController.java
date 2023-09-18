package com.codegym.controller;

import com.codegym.model.MailConfig;
import com.codegym.service.IMailConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MailConfigController {
    @Autowired
    private IMailConfigService service;
    @GetMapping("")
    public String showForm(Model model) {
        model.addAttribute("mailConfig", new MailConfig());
        model.addAttribute("language", this.service.showLanguagesOption());
        model.addAttribute("sizes", this.service.showSizeOption());
        return "index";
    }

    @PostMapping("save")
    public String save(@ModelAttribute MailConfig mailConfig,
                       RedirectAttributes redirectAttributes) {
        this.service.saveConfig(mailConfig);
        redirectAttributes.addFlashAttribute("message","Added successfully");
        return "redirect:/";
    }

    @GetMapping("show-config")
    public String showConfig(Model model) {
        MailConfig mailConfigs = this.service.showConfig();
        model.addAttribute("mailConfigs", mailConfigs);
        return "show";
    }
}
