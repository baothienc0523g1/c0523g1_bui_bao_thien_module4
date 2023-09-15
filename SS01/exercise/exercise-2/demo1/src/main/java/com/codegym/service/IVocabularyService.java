package com.codegym.service;

import java.util.Map;

public interface IVocabularyService {
    Map<String, String> showList();
    String search(String keyWord);

}
