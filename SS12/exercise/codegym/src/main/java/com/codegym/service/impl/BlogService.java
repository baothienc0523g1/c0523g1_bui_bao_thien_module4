package com.codegym.service.impl;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return this.blogRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public void add(Blog blog) {
        try {
            this.blogRepository.save(blog);
        } catch (Exception e) {
            System.out.println("Error while adding blog: " + e.getMessage());
        }
    }

    @Override
    public List<Blog> searchByName(String name) {
        return this.blogRepository.searchBlogByName(name);
    }
}
