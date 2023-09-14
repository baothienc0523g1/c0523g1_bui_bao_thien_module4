package com.codegym.repository;

import java.util.Map;

public interface IRepository {
    Map<String, String> showList();
    String search(String keyWord);
}
