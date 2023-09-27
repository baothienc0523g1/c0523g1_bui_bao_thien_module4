package com.codegym.demo.service;

import com.codegym.demo.model.Book;
import com.codegym.demo.model.BookType;

import java.util.List;

public interface IBookService {
    List<Book> findAllByBookTypeAndStatusIsFalse(BookType bookType);
    List<Book> findAll(boolean status);

    void save(Book Book);

    void delete(int id);
    Book findById(int id);
}
