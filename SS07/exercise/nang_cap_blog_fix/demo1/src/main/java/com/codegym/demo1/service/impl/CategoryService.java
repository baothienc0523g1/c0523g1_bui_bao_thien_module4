package com.codegym.demo1.service.impl;

import com.codegym.demo1.model.Category;
import com.codegym.demo1.repository.ICategoryRepository;
import com.codegym.demo1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public void add(Category category) {
        this.categoryRepository.save(category);
    }

    @Override
    public void update(Category category) {
        this.categoryRepository.save(category);
    }

    @Override
    public void delete(int id) {
        Category existedCategory = this.categoryRepository.findById(id).get();
        this.categoryRepository.delete(existedCategory);
    }

    @Override
    public Category findById(int id) {
        return this.categoryRepository.findById(id).get();
    }
}
