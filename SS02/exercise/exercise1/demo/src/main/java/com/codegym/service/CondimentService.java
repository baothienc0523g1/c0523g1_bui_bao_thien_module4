package com.codegym.service;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class CondimentService implements ICondimentService {

    private static List<String> list = new ArrayList<>();
    @Override
    public void save(String[] condiment) {
        for (String str : condiment) {
            list.add(str);
        }
    }

    @Override
    public List<String> findAll() {
        return list;
    }
}
