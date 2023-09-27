package com.codegym.service;

import com.codegym.model.Book;
import com.codegym.model.BookType;

import java.util.List;

public interface IBookService {
    List<Book> findAllByBookTypeAndStatusIsFalse(BookType bookType);

    List<Book> findAll();

    void save(Book book);

    void delete(int id);

    Book findById(int id);
}
