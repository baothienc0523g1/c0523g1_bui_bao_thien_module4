package com.codegym.service;

import com.codegym.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@org.springframework.stereotype.Service
public class Service implements IService{
    @Autowired
    private IRepository repository;
    @Override
    public Map<String, String> showList() {
        return repository.showList();
    }

    @Override
    public String search(String keyWord) {
        return repository.search(keyWord.toLowerCase());
    }
}
