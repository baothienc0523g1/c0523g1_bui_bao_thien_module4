package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/categories")
public class RestCategoryController {
    @Autowired
    private ICategoryService categoryService;

    //Get category list
    @GetMapping
    public ResponseEntity<List<Category>> getCategoryList() {
        List<Category> categories = this.categoryService.findAllCategory();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    //Add category
    @PostMapping
    public ResponseEntity<?> addCategory(@Valid @ModelAttribute(name = "category") Category category,
                                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.categoryService.addCategory(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
