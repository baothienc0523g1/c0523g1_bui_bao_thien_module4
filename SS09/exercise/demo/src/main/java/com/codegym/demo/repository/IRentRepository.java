package com.codegym.demo.repository;

import com.codegym.demo.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentRepository extends JpaRepository<Rent, Integer> {
    Rent findRentsByCode(Integer code);
}
