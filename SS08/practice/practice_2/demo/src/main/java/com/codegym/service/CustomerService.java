package com.codegym.service;

import com.codegym.exception.DuplicateEmailException;
import com.codegym.model.Customer;
import com.codegym.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) throws DuplicateEmailException {
        try {
            this.customerRepository.save(customer);
        } catch (DataIntegrityViolationException dive) {
            throw new DuplicateEmailException();
        }
    }

    @Override
    public Customer findById(int id) {
        return this.customerRepository.findById(id).get();
    }

    @Override
    public void remove(int id) {
        this.customerRepository.deleteById(id);
    }
}
