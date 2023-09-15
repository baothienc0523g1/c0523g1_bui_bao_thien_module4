package com.codegym.service;

import com.codegym.repository.IVocabularyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@org.springframework.stereotype.Service
public class VocabularyService implements IVocabularyService {
    @Autowired
    private IVocabularyRepository vocabularyRepository;
    @Override
    public Map<String, String> showList() {
        return vocabularyRepository.showList();
    }

    @Override
    public String search(String keyWord) {
        String searched = vocabularyRepository.search(keyWord.toLowerCase());
        String notFound = "Can't find this word";
        if (searched != null ) {
            return searched;
        } else {
            return notFound;
        }
    }
}
