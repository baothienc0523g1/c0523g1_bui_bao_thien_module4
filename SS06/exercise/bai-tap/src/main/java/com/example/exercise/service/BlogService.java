package com.example.exercise.service;

import com.example.exercise.model.Blog;
import com.example.exercise.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> showList() {
        return this.blogRepository.findAll();
    }

    @Override
    public void createBlog(Blog blog) {
        this.blogRepository.save(blog);
    }

    @Override
    public void editBlog(Blog blog) {
        this.blogRepository.save(blog);
    }

    @Override
    public Blog blogView(int id) {
        Blog existedBlog = this.blogRepository.findById(id).get();
        return existedBlog;
    }

    @Override
    public boolean removeBlog(int id) {
        Blog existedBlog = this.blogRepository.findById(id).get();
        if (existedBlog != null) {
            this.blogRepository.delete(existedBlog);
            return true;
        } else {
            return false;
        }
    }

}
