package com.codegym.demo1.service;

import com.codegym.demo1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> searchBlogByCategory(int categoryId);

    Page<Blog> findAll(Pageable pageable, String search);

    void add(Blog blog);

    void update(Blog blog);

    void delete(int id);

    Blog findById(int id);

    List<Blog> findBlogByCategoryName(String name);
}
