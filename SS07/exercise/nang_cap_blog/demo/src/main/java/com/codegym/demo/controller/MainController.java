package com.codegym.demo.controller;

import com.codegym.demo.model.Blog;
import com.codegym.demo.model.Category;
import com.codegym.demo.service.IBlogService;
import com.codegym.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    //main page
    @GetMapping("/")
    public String index(@PageableDefault(value = 0, size = 3) Pageable pageable,
                        Model model) {
        Page<Blog> blogs = this.blogService.findAll(pageable);
        List<Category> categories = this.categoryService.findAllCategory();
        model.addAttribute("blogs", blogs);
        model.addAttribute("categories", categories);
        return "index";
    }

    //back
    @GetMapping("/back")
    public String back() {
        return "redirect:/";
    }

    //BLOG REQUEST MAPPING
    //add blog
    @GetMapping("/add")
    public String showAddForm(Model model) {
        List<Category> categories = this.categoryService.findAllCategory();
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", categories);
        return "addBlog";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Blog blog,
                      RedirectAttributes redirectAttributes) {
        this.blogService.createBlog(blog);
        redirectAttributes.addFlashAttribute("message", "Added new blog success!!");
        return "redirect:/";
    }

    //CATEGORY REQUEST MAPPING
    //add category
    @GetMapping("/addCategory")
    public String showAddCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "addCategory";
    }

    @PostMapping("/addCategory")
    public String addCategory(@ModelAttribute Category category,
                              RedirectAttributes redirectAttributes) {
        this.categoryService.createCategory(category);
        redirectAttributes.addFlashAttribute("message", "Added new category success!!");
        return "redirect:/";
    }
    //show category
    @GetMapping("/showCategory")
    public String showCategory(Model model) {
        List<Category> categories = this.categoryService.findAllCategory();
        model.addAttribute("categories",categories);
        return "categoryList";
    }
    //delete category
    @DeleteMapping()
}
