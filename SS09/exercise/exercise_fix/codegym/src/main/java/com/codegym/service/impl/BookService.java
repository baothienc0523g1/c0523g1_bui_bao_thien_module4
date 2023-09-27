package com.codegym.service.impl;

import com.codegym.model.Book;
import com.codegym.model.BookType;
import com.codegym.repository.IBookRepository;
import com.codegym.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;
    @Override
    public List<Book> findAllByBookTypeAndStatusIsFalse(BookType bookType) {
        return this.bookRepository.findAllByBookTypeAndStatusIsFalse(bookType);
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        this.bookRepository.save(book);
    }

    @Override
    public void delete(int id) {
        Book existedBook = this.bookRepository.findById(id).get();
        this.bookRepository.delete(existedBook);
    }

    @Override
    public Book findById(int id) {
        return this.bookRepository.findById(id).get();
    }
}
