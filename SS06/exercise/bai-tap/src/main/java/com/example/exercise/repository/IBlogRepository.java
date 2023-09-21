package com.example.exercise.repository;

import com.example.exercise.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
}
