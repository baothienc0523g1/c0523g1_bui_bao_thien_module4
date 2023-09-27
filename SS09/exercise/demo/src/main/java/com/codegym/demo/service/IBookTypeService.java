package com.codegym.demo.service;

import com.codegym.demo.model.BookType;

import java.util.List;

public interface IBookTypeService {
    List<BookType> findAll();
    void add(BookType bookType);
    BookType findById(int id);
}
