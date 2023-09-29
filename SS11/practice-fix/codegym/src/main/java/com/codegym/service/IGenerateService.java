package com.codegym.service;

import java.util.List;

public interface IGenerateService<E> {
    List<E> findAll();

    E findById(Long id);

    E save(E e);

    void remove(Long id);

}
