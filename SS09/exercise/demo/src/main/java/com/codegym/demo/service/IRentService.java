package com.codegym.demo.service;

import com.codegym.demo.model.Rent;

public interface IRentService {
    void add(Rent rent);
    void remove(int id);
    boolean findByCode(int code);
    Integer codeGeneration();
}
