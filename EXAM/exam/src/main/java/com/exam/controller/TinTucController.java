package com.exam.controller;

import com.exam.dto.TinTucDto;
import com.exam.mode.DanhMuc;
import com.exam.mode.TinTuc;
import com.exam.service.IDanhMucService;
import com.exam.service.ITinTucService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class TinTucController {
    @Autowired
    private ITinTucService tinTucService;

    @Autowired
    private IDanhMucService danhMucService;

    @GetMapping
    public String index(@RequestParam(defaultValue = "0", required = false) int page,
                        @RequestParam(defaultValue = "", required = false) String tieuDe,
                        @RequestParam(defaultValue = "", required = false) String danhMuc,
                        Model model) {
        Pageable pageable = PageRequest.of(page, 3);
        Page<TinTuc> tinTucs = this.tinTucService.danhSachTinTuc(pageable);

        List<DanhMuc> danhSachDanhMuc = this.danhMucService.danhSachDanhMuc();

        model.addAttribute("tinTucs", tinTucs);
        model.addAttribute("page", page);
        model.addAttribute("tieuDe", tieuDe);
        model.addAttribute("danhMuc", danhMuc);
        model.addAttribute("danhSachDanhMuc", danhSachDanhMuc);
        return "tin-tuc-list";
    }

    @GetMapping("/back")
    public String backTinTuc() {
        return "redirect:/";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        List<DanhMuc> danhMucs = this.danhMucService.danhSachDanhMuc();
        model.addAttribute("tinTuc", new TinTucDto());
        model.addAttribute("danhMucs", danhMucs);
        return "tin-tuc-add";
    }

    @PostMapping("/add")
    public String addTinTuc(@Valid @ModelAttribute TinTucDto tinTucDto,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {
        //validate
        new TinTucDto().validate(tinTucDto, bindingResult);

        if (bindingResult.hasErrors()) {
            return "/tin-tuc-add";
        }

        //if nothing gone wrong
        TinTuc tinTuc = new TinTuc();
        BeanUtils.copyProperties(tinTucDto, tinTuc);
        this.tinTucService.add(tinTuc);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công tin tức " +
                "với tiêu đề: " + tinTuc.getTieuDe());
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") int id) {
        this.tinTucService.delete(id);
        return "redirect:/";
    }
}
