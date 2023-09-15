package com.codegym.repository;

import com.codegym.model.Customer;

import java.util.List;

public interface IRepository {
    List<Customer> findAll();
    Customer findByID(int id);
    void save(Customer customer);
}
