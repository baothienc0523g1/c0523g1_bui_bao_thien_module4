package com.codegym.controller;

import com.codegym.dto.BlogDto;
import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/blogs")
@CrossOrigin("*")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping
    public ResponseEntity<Page<Blog>> showBlogList(@RequestParam(defaultValue = "0", required = false) Integer page) {
        Pageable pageable = PageRequest.of(page, 3, Sort.by("dayCreate").ascending());
        Page<Blog> blogs = this.blogService.findAll(pageable);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(blogs, HttpStatus.OK);
        }
    }

    @GetMapping("/{searchWord}")
    public ResponseEntity<List<Blog>> searchBlogByName(@PathVariable(name = "searchWord") String searchWord) {
        List<Blog> blogs = this.blogService.searchByName(searchWord);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(blogs, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<?> addNewBlog(@Valid @RequestBody BlogDto blogDto) {
        if (blogDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            Blog blog = new Blog();
            BeanUtils.copyProperties(blogDto, blog);
            this.blogService.add(blog);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
}
