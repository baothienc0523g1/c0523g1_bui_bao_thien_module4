package com.codegym.demo.repository;

import com.codegym.demo.model.BookType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookTypeRepository extends JpaRepository<BookType, Integer> {
}
