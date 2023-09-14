package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.repository.IRepository;
import com.codegym.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service implements IService{
    @Autowired
    private IRepository repository;
    @Override
    public List<Customer> showList() {
        return repository.showList();
    }
}
