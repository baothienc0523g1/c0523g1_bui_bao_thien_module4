package com.codegym.demo1.service.impl;

import com.codegym.demo1.model.Blog;
import com.codegym.demo1.repository.IBlogRepository;
import com.codegym.demo1.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> searchBlogByCategory(int categoryId) {
        return this.blogRepository.searchByCategory(categoryId);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable, String search) {
        return this.blogRepository.findAllByNameContaining(pageable, search);
    }

    @Override
    public void add(Blog blog) {
        this.blogRepository.save(blog);
    }

    @Override
    public void update(Blog blog) {
        this.blogRepository.save(blog);
    }

    @Override
    public void delete(int id) {
        Blog existedBlog = this.blogRepository.findById(id).get();
        this.blogRepository.delete(existedBlog);
    }

    @Override
    public Blog findById(int id) {
        return this.blogRepository.findById(id).get();
    }

    @Override
    public List<Blog> findBlogByCategoryName(String name) {
        return this.blogRepository.findBlogByCategoryName(name);
    }
}
