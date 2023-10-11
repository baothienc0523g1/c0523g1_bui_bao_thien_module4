package com.example.thi.controller;

import com.example.thi.dto.HeoDto;
import com.example.thi.model.Heo;
import com.example.thi.model.XuatXu;
import com.example.thi.service.IHeoService;
import com.example.thi.service.IXuatXuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("heos")
public class HeoController {
    @Autowired
    private IHeoService heoService;
    @Autowired
    private IXuatXuService xuatXuService;

    @GetMapping("")
    public String showAll(Model model,
                          @RequestParam(defaultValue = "0", required = false) int page,
                          @RequestParam(defaultValue = "", required = false) String maHeo,
                          @RequestParam(defaultValue = "", required = false) String tinhTrang,
                          @RequestParam(defaultValue = "", required = false) String xuatXu) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<Heo> heoPage = heoService.danhSachHeo(pageable, maHeo, tinhTrang, xuatXu);
        List<XuatXu> danhSachXuatXu = xuatXuService.danhSachXuatXu();
        model.addAttribute("heoPage", heoPage);
        model.addAttribute("maHeo", maHeo);
        model.addAttribute("tinhTrang", tinhTrang);
        model.addAttribute("xuatXu", xuatXu);
        model.addAttribute("danhSachXuatXu", danhSachXuatXu);
        return "list";
    }

    @GetMapping("tao")
    public String showFormCreate(Model model) {
        model.addAttribute("heoDto", new HeoDto());
        model.addAttribute("danhSachXuatXu", xuatXuService.danhSachXuatXu());
        return "create";
    }

    @PostMapping("tao")
    public String create(@Valid @ModelAttribute HeoDto heoDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        Heo heo = new Heo();
        BeanUtils.copyProperties(heoDto, heo);
        try {
            heoService.themHeo(heo);
            redirectAttributes.addFlashAttribute("message", "Thêm mới thàng công");
        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("message", "Mã heo đã tồn tại!!!");
        }
        return "redirect:/heos/tao";
    }

    @GetMapping("xem/{ma}")
    public String detail(Model model, @PathVariable int ma) {
        model.addAttribute("heo", heoService.timHeo(ma));
        return "detail";
    }

    @PostMapping("xoa")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        heoService.xoa(id);
        redirectAttributes.addFlashAttribute("message", "Xóa thành công!");
        return "redirect:/heos";
    }


}
