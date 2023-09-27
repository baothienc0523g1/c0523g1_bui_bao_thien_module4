package com.codegym.service;

import com.codegym.model.Rent;

public interface IRentService {
    void add(Rent rent);
    void remove(int id);
    Rent findByCode(int code);
    Integer codeGeneration();
    boolean existedCode(int code);
}
