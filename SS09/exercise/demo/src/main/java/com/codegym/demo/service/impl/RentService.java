package com.codegym.demo.service.impl;

import com.codegym.demo.model.Rent;
import com.codegym.demo.repository.IRentRepository;
import com.codegym.demo.service.IRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentService implements IRentService {
    @Autowired
    private IRentRepository rentRepository;

    @Override
    public void add(Rent rent) {
        this.rentRepository.save(rent);
    }

    @Override
    public void remove(int id) {
        Rent existedRent = this.rentRepository.findById(id).get();
        this.rentRepository.delete(existedRent);
    }

    @Override
    public boolean findByCode(int code) {
        Rent rent = this.rentRepository.findRentsByCode(code);
        return rent != null;
    }

    public Integer codeGeneration() {
        boolean flag;
        Integer code;
        do {
            code = (int) (Math.random() * 100000);
            flag = findByCode(code);
        } while (flag);
        return code;
    }
}
