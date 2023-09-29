package com.codegym.service.impl;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.repository.IBlogRepository;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAllBLog() {
        return this.blogRepository.findAll();
    }

    @Override
    public List<Blog> findAllByCategory(Category category) {
        return this.blogRepository.findAllByCategory(category);
    }

    @Override
    public Blog blogDetail(Long blogId) {
        return this.blogRepository.findById(blogId)
                .orElseThrow(() -> new IllegalArgumentException("Cant found this blog"));
    }

    @Transactional
    @Override
    public void addBlog(Blog blog) {
        try {
            this.blogRepository.save(blog);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public Blog findById(Long id) {
        return this.blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cant found blog with id: " + id));
    }
}
