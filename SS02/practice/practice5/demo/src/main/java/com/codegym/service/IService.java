package com.codegym.service;

import com.codegym.model.Customer;

import java.util.List;

public interface IService {
    List<Customer> findAll();
    Customer findById(int id);
    void save(Customer customer);
}
