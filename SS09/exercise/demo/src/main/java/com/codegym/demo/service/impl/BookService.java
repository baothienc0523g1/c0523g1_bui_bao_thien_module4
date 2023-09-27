package com.codegym.demo.service.impl;

import com.codegym.demo.model.Book;
import com.codegym.demo.model.BookType;
import com.codegym.demo.repository.IBookRepository;
import com.codegym.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<Book> findAll(boolean status) {
        return this.bookRepository.findAllByStatus(status);
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
    public List<Book> findAllByBookTypeAndStatusIsFalse(BookType bookType) {
        return this.bookRepository.findAllByBookTypeAndStatusIsFalse(bookType);
    }

    @Override
    public Book findById(int id) {
        return this.bookRepository.findById(id).get();
    }
}
