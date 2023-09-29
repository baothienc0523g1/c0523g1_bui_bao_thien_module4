package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface IBlogService {
    List<Blog> findAllBLog();
    List<Blog> findAllByCategory(Category category);
    Blog blogDetail(Long blogId);
    void addBlog(Blog blog);
    Blog findById(Long id);
}
