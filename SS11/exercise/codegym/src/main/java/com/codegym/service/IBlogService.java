package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface IBlogService {
    Page<Blog> findAllBLog(Pageable pageable, String summary);
    Page<Blog> findAllByCategory(Pageable pageable, Category category);
    Optional<Blog> blogDetail(Long blogId);
    void addBlog(Blog blog);
    Blog findById(Long id);
}
