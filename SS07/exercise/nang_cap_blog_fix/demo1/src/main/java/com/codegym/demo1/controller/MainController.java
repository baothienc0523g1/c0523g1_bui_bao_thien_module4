package com.codegym.demo1.controller;

import com.codegym.demo1.model.Blog;
import com.codegym.demo1.model.Category;
import com.codegym.demo1.service.IBlogService;
import com.codegym.demo1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IBlogService blogService;

    @GetMapping("/")
    public ModelAndView index(@RequestParam(defaultValue = "0", required = false) int page,
                              @RequestParam(defaultValue = "", required = false) String search) {
        Pageable pageable = PageRequest.of(page, 3, Sort.by("dayCreate").descending());
        Page<Blog> blogs = this.blogService.findAll(pageable, search);
        List<Category> categories = this.categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("index", "blogs", blogs);
        modelAndView.addObject("search", search);
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @GetMapping("/back")
    public String back() {
        return "redirect:/";
    }


    //  -------------BLOG REQUEST MAPPING-------------
    // add
    @GetMapping("/add")
    public String showAddForm(Model model) {
        List<Category> categories = this.categoryService.findAll();
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", categories);
        return "blog-add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Blog blog,
                      RedirectAttributes redirectAttributes) {
        this.blogService.add(blog);
        redirectAttributes.addFlashAttribute("message", "Added new blog success!!");
        return "redirect:/";
    }

    // delete
    @GetMapping("/deleteBlog/{id}")
    public String deleteBlog(@PathVariable int id,
                             RedirectAttributes redirectAttributes) {
        this.blogService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Blog id removed");
        return "redirect:/";
    }

    // read
    @GetMapping("/readBlog/{id}")
    public String readBLog(@PathVariable int id, Model model) {
        Blog blog = this.blogService.findById(id);
        model.addAttribute("blog", blog);
        return "blog-read";
    }

    // edit
    @GetMapping("/editBlog/{id}")
    public String editBlog(@PathVariable int id, Model model) {
        List<Category> categories = this.categoryService.findAll();
        Blog existedBlog = this.blogService.findById(id);
        model.addAttribute("existedBlog", existedBlog);
        model.addAttribute("categories", categories);
        return "blog-edit";
    }

    @PostMapping("/editBlog")
    public String editBlog(@ModelAttribute Blog blog) {
        this.blogService.add(blog);
        return "redirect:/";
    }

    // show blog with category
    @GetMapping("/blogWithCategory/{categoryName}")
    public String blogWithCategory(@PathVariable String categoryName, Model model) {
        List<Blog> blogsWithCategory = this.blogService.findBlogByCategoryName(categoryName);
        model.addAttribute("blogsWithCategory",blogsWithCategory);
        model.addAttribute("categoryName",categoryName);
        return "blog-with-category-type";
    }

    //  -------------CATEGORY REQUEST MAPPING-------------
    //add
    @GetMapping("/addCategory")
    public String showAddCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "category-add";
    }

    @PostMapping("/addCategory")
    public String addCategory(@ModelAttribute Category category,
                              RedirectAttributes redirectAttributes) {
        this.categoryService.add(category);
        redirectAttributes.addFlashAttribute("message", "Added new category success!!");
        return "redirect:/";
    }

    //show list
    @GetMapping("/showCategory")
    public String showCategory(Model model) {
        List<Category> categories = this.categoryService.findAll();
        model.addAttribute("categories", categories);
        return "category-list";
    }

    //delete category
    @GetMapping("/deleteCategory")
    public String deleteCategory(@RequestParam int id,
                                 RedirectAttributes redirectAttributes,
                                 @ModelAttribute Category category) {
        this.categoryService.delete(category.getId());
        redirectAttributes.addFlashAttribute("message", "Category is removed");
        return "redirect:/showCategory";
    }

    //edit category
    @GetMapping("/editCategory")
    public String showEditForm(@RequestParam int id, Model model) {
        Category category = this.categoryService.findById(id);
        model.addAttribute("category", category);
        return "category-edit";
    }

    @PostMapping("/editCategory")
    public String editCategory(@ModelAttribute Category category) {
        this.categoryService.add(category);
        return "redirect:/showCategory";
    }
}
