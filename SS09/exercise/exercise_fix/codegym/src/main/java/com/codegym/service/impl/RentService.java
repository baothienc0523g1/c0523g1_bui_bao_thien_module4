package com.codegym.service.impl;

import com.codegym.model.Rent;
import com.codegym.repository.IRentRepository;
import com.codegym.service.IRentService;
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
    public Rent findByCode(int code) {
        Rent rent = this.rentRepository.findByCode(code);
        return rent;
    }

    @Override
    public Integer codeGeneration() {
        boolean flag;
        Integer code;
        do {
            code = (int) (Math.random() * 100000);
            flag = existedCode(code);
        } while (flag);
        return code;
    }

    @Override
    public boolean existedCode(int code) {
        return findByCode(code) != null;
    }
}
