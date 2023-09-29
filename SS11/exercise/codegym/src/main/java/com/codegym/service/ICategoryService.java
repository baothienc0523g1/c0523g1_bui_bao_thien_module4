package com.codegym.service;

import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.swing.text.html.Option;

public interface ICategoryService {
    Page<Category> findAllCategory(Pageable pageable, String search);
    Category findCategoryById(Long id);
    void addCategory(Category category);
}
