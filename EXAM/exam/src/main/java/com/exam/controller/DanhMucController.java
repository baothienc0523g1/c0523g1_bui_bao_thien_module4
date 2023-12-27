package com.exam.controller;

import com.exam.dto.DanhMucDto;
import com.exam.mode.DanhMuc;
import com.exam.service.IDanhMucService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/danh-muc")
public class DanhMucController {

    @Autowired
    private IDanhMucService danhMucService;

    @GetMapping("/show-list")
    public String danhSachDanhMuc(Model model) {
        List<DanhMuc> danhSachDanhMuc = this.danhMucService.danhSachDanhMuc();
        model.addAttribute("danhSachDanhMuc",danhSachDanhMuc);
        return "/danh-muc-list";
    }

    @GetMapping("/back")
    public String back() {
        return "redirect:/danh-muc/show-list";
    }
    @GetMapping("/add")
    public String danhMucAddForm(Model model) {
        model.addAttribute("danhMucDto", new DanhMucDto());
        return "/danh-muc-add";
    }

    @PostMapping("/add")
    public String danhMucAdd(@Valid @ModelAttribute DanhMucDto danhMucDto, RedirectAttributes redirectAttributes) {
        DanhMuc danhMuc = new DanhMuc();
        BeanUtils.copyProperties(danhMucDto, danhMuc);
        this.danhMucService.add(danhMuc);
        return "redirect:/danh-muc/show-list";
    }
}
