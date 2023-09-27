package com.codegym.service;

import com.codegym.model.BookType;

import java.util.List;

public interface IBookTypeService {
    List<BookType> findAll();
    void add(BookType bookType);
    BookType findById(int id);
}
