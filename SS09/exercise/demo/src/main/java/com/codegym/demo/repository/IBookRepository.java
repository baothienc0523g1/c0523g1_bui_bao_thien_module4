package com.codegym.demo.repository;

import com.codegym.demo.model.Book;
import com.codegym.demo.model.BookType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBookRepository extends JpaRepository<Book, Integer> {
    List<Book> findAllByBookTypeAndStatusIsFalse(BookType bookType);
    List<Book> findAllByStatus(boolean status);

}
