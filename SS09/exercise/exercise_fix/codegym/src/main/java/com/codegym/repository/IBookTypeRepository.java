package com.codegym.repository;

import com.codegym.model.Book;
import com.codegym.model.BookType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBookTypeRepository extends JpaRepository<BookType, Integer> {

}
