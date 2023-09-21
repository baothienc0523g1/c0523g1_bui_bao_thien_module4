package com.example.exercise.service;

import com.example.exercise.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> showList();
    void createBlog(Blog blog);
    void editBlog(Blog blog);
    Blog blogView(int id);
    boolean removeBlog(int id);
}
