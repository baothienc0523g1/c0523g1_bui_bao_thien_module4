package com.codegym.service;

import com.codegym.exception.DuplicateEmailException;

import java.util.List;

public interface IGenerateService<T> {
    List<T> findAll();
    void save(T t) throws DuplicateEmailException;
    T findById(int id);
    void remove(int id);
}
