package com.example.exercise.controller;

import com.example.exercise.model.Blog;
import com.example.exercise.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    //show list
    @GetMapping("/")
    public String index(Model model) {
        List<Blog> blogs = this.blogService.showList();
        model.addAttribute("blogs", blogs);
        return "index";
    }

    //back to main menu
    @GetMapping("/back")
    public String back() {
        return "redirect:/";
    }

    //add
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Blog blog) {
        this.blogService.createBlog(blog);
        return "redirect:/";
    }

    //read blog
    @PostMapping("/detail")
    public String read(@RequestParam int id, Model model) {
        Blog blog = this.blogService.blogView(id);
        model.addAttribute("blog", blog);
        return "detail";
    }

    //edit
    @PostMapping("/editForm")
    public String edit(Model model,
                       @RequestParam int id) {
        Blog blog = this.blogService.blogView(id);
        model.addAttribute("blog", blog);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(Model model, @ModelAttribute Blog blog) {
        this.blogService.createBlog(blog);
        return "redirect:/";
    }

    //delete
    @PostMapping("/delete")
    public String delete(@RequestParam int id,
                         RedirectAttributes redirectAttributes) {
        Blog blog = this.blogService.blogView(id);
        if (blog != null) {
            this.blogService.removeBlog(id);
            redirectAttributes.addFlashAttribute("remove", "Blog is removed");
        } else {
            redirectAttributes.addFlashAttribute("remove", "Cant find this blog");
        }
        return "redirect:/";
    }
}
