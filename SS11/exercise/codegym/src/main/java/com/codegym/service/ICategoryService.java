package com.codegym.service;

import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.swing.text.html.Option;
import java.util.List;

public interface ICategoryService {
    List<Category> findAllCategory();
    Category findCategoryById(Long id);
    void addCategory(Category category);
}
