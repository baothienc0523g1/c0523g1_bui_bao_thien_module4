package com.codegym.service;

import java.util.Map;

public interface IService {
    Map<String, String> showList();
    String search(String keyWord);

}
