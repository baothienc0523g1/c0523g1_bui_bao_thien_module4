package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/blogs")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;


    //Get blog list
    @GetMapping
    public ResponseEntity<List<Blog>> getBlogList() {

        List<Blog> blogs = this.blogService.findAllBLog();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    //Get blog list with category
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Blog>> getBlogListWithCategory(@PathVariable(name = "categoryId") Long categoryId) {
        Category existedCategory = this.categoryService.findCategoryById(categoryId);
        List<Blog> blogsWithCategory = this.blogService.findAllByCategory(existedCategory);
        if (blogsWithCategory.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogsWithCategory, HttpStatus.OK);
    }

    //Blog detail
    @GetMapping("/{blogId}")
    public ResponseEntity<Blog> showBlogDetail(@PathVariable(name = "blogId") Long blogId) {
        Blog existedBLog = this.blogService.findById(blogId);
        if (existedBLog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(existedBLog, HttpStatus.OK);
    }

    //Blog add
    @PostMapping
    public ResponseEntity<?> addBlog(@Valid @ModelAttribute(name = "blog") Blog blog,
                                     BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.blogService.addBlog(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
