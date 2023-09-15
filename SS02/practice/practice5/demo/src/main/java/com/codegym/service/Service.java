package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@org.springframework.stereotype.Service
public class Service implements IService{
    @Autowired
    private IRepository repository;
    @Override
    public List<Customer> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return this.repository.findByID(id);
    }
    public void save(Customer customer) {
        this.repository.save(customer);
    }
}
