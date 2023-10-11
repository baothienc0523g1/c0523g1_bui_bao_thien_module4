package com.example.demo.controller;

import com.example.demo.dto.HeoDto;
import com.example.demo.dto.HeoDtoTruyVan;
import com.example.demo.model.Heo;
import com.example.demo.model.XuatXu;
import com.example.demo.service.IHeoService;
import com.example.demo.service.IXuatXuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping({"/heo", ""})
public class HeoController {
    @Autowired
    private IHeoService heoService;

    @Autowired
    private IXuatXuService xuatXuService;

    @GetMapping
    public String index(Model model,
                        @RequestParam(defaultValue = "0", required = false) int soTrang,
                        @RequestParam(defaultValue = "", required = false) String timKiem) {
        Pageable pageable = PageRequest.of(soTrang, 5);
        Page<Heo> heos = this.heoService.heoList(pageable, timKiem);
        model.addAttribute("heos", heos);
        model.addAttribute("soTrang", soTrang);
        model.addAttribute("timKiem", timKiem);
        return "/index";
    }

    @GetMapping("/add")
    public String themHeo(Model model) {
        List<XuatXu> xuatXus = this.xuatXuService.findAll();
        model.addAttribute("heo", new Heo());
        model.addAttribute("xuatXus", xuatXus);
        return "/heo-them";
    }

    @PostMapping("/add")
    public String themHeoVoDataBase(@Valid @ModelAttribute Heo heo,
                                    RedirectAttributes redirectAttributes,
                                    BindingResult bindingResult) {


        this.heoService.add(heo);
        String message = "thêm heo thành công";
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/";
    }
}
