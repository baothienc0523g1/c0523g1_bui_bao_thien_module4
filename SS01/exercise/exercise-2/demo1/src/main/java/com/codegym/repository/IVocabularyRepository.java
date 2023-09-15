package com.codegym.repository;

import java.util.Map;

public interface IVocabularyRepository {
    Map<String, String> showList();
    String search(String keyWord);
}
