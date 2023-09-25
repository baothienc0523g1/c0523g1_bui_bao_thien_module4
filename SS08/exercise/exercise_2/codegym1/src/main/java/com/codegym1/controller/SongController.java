package com.codegym1.controller;

import com.codegym1.dto.SongDto;
import com.codegym1.model.Song;
import com.codegym1.service.ISongService;
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
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("/")
    public String index(Model model) {
        List<Song> songs = this.songService.findALl();
        model.addAttribute("songs", songs);
        return "index";
    }

    @GetMapping("/back")
    public String back() {
        return "redirect:/";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "add";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute SongDto songDto,
                      Model model,
                      BindingResult bindingResult) {
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "add";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        this.songService.add(song);
        model.addAttribute("songName", song.getName());
        return "result";
    }
}
