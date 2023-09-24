package com.codegym.demo1.service;

import com.codegym.demo1.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    void add(Category category);
    void update(Category category);
    void delete(int id);
    Category findById(int id);
}
