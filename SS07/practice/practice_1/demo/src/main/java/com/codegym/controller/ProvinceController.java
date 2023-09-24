package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.model.Province;
import com.codegym.service.ICustomerService;
import com.codegym.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/provinces")
public class ProvinceController {
    @Autowired
    private IProvinceService provinceService;
    @Autowired
    private ICustomerService customerService;

    @GetMapping
    public ModelAndView listProvince(){
        ModelAndView modelAndView = new ModelAndView("/province/list");
        Iterable<Province> provinces = provinceService.findAll();
        modelAndView.addObject("provinces",provinces);
        return modelAndView;
    }

    @GetMapping("/create")
    public String create(@ModelAttribute("province") Province province,
                         RedirectAttributes redirectAttributes) {
        this.provinceService.save(province);
        redirectAttributes.addFlashAttribute("message","Created new province");
        return "redirect:/provinces";
    }
    @GetMapping("/update/{id}")
    public ModelAndView updateForm(@PathVariable int id) {
        Optional<Province> province = this.provinceService.findById(id);
        if(province.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/province/update");
            modelAndView.addObject("province",province.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error_404");
        }
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("province") Province province,
                         RedirectAttributes redirectAttributes) {
        this.provinceService.save(province);
        redirectAttributes.addFlashAttribute("message","Province updated");
        return "redirect:/provinces";
    }

    @GetMapping("view-province/{id}")
    public ModelAndView viewProvince(@PathVariable("id") int id) {
        Optional<Province> provinceOptional = this.provinceService.findById(id);
        if(!provinceOptional.isPresent()) {
            return new ModelAndView("/error_404");
        }
        Iterable<Customer> customers = this.customerService.findAllByProvince(provinceOptional.get());

        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers",customers);
        return modelAndView;
    }
}
