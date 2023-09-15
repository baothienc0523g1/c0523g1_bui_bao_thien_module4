package com.codegym.repository;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Repository
public class VocabularyRepository implements IVocabularyRepository {
    private static Map<String, String> vocabulary = new HashMap<>();

    static {
        vocabulary.put("apple", "Táo");
        vocabulary.put("orange", "Cam");
        vocabulary.put("chilli", "Ớt");
        vocabulary.put("pepper", "Tiêu");
        vocabulary.put("banana", "Chuối");
        vocabulary.put("watermelon", "Dưa hấu");
    }

    @Override
    public Map<String, String> showList() {
        return vocabulary;
    }

    @Override
    public String search(String keyWord) {
        String notice = vocabulary.get(keyWord);
        return notice;
    }
}
