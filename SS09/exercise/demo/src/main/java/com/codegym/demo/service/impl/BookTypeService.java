package com.codegym.demo.service.impl;

import com.codegym.demo.model.BookType;
import com.codegym.demo.repository.IBookTypeRepository;
import com.codegym.demo.service.IBookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookTypeService implements IBookTypeService {
    @Autowired
    private IBookTypeRepository bookTypeRepository;
    @Override
    public List<BookType> findAll() {
        return this.bookTypeRepository.findAll();
    }

    @Override
    public void add(BookType bookType) {
        this.bookTypeRepository.save(bookType);
    }

    @Override
    public BookType findById(int id) {
        return this.bookTypeRepository.findById(id).get();
    }
}
