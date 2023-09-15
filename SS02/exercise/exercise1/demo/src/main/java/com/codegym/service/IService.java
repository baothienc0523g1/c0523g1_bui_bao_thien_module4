package com.codegym.service;

import java.util.List;

public interface IService {
    void save(String[] condiment);
    List<String> findAll();
}
