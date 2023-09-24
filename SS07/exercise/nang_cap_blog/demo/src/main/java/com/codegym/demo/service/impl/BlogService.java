package com.codegym.demo.service;

import com.codegym.demo.model.Blog;
import com.codegym.demo.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        Page<Blog> blogs = this.blogRepository.findAll(pageable);
        return blogs;
    }
}
