package com.codegym.service;

import java.util.List;

public interface ICondimentService {
    void save(String[] condiment);
    List<String> findAll();
}
