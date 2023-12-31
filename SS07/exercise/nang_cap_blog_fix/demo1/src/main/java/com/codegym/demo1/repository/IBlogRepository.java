package com.codegym.demo1.repository;

import com.codegym.demo1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllByNameContaining(Pageable pageable, String search);

    @Query(value = "select * from blogs where category_id = :id", nativeQuery = true)
    List<Blog> searchByCategory(@Param("id") int id);

    List<Blog> findBlogByCategoryName(String name);
}
