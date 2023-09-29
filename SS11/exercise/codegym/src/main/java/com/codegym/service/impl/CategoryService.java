package com.codegym.service.impl;

import com.codegym.model.Category;
import com.codegym.repository.ICategoryRepository;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public Page<Category> findAllCategory(Pageable pageable, String search) {
        return this.categoryRepository.findAllByName(pageable, search);
    }

    @Override
    public Category findCategoryById(Long id) {
        return this.categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cant not found this category"));
    }

    @Transactional
    @Override
    public void addCategory(Category category) {
        try {
            this.categoryRepository.save(category);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}

