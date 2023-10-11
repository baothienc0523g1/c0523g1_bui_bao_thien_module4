package com.example.demo.controller;

import com.example.demo.dto.HeoDto;
import com.example.demo.dto.XuatXuDto;
import com.example.demo.model.XuatXu;
import com.example.demo.service.IXuatXuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/xuat-xu")
public class XuatXuController {
    @Autowired
    private IXuatXuService xuatXuService;
    @GetMapping("/add")
    public String themXuatXu(Model model) {
        model.addAttribute("xuatXu", new XuatXuDto());
        return "xuat-xu-them";
    }

    @PostMapping("/add")
    public String themXuatXuVoDB(@ModelAttribute XuatXuDto xuatXuDto) {
        XuatXu xuatXu = new XuatXu();
        BeanUtils.copyProperties(xuatXuDto,xuatXu);
        this.xuatXuService.add(xuatXu);
        return "redirect:/heo";
    }
    @GetMapping
    public String xuatXu(Model model) {
        List<XuatXu> xuatXus = this.xuatXuService.findAll();
        model.addAttribute("xuatXus",xuatXus);
        return "xuat-xu-list";
    }
}
