package com.codegym.controller;

import com.codegym.service.IVocabularyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@org.springframework.stereotype.Controller
public class VocabularyController {
    @Autowired
    private IVocabularyService vocabularyService;

    @GetMapping("")
    public String showForm(Model model) {
        Map<String, String> vocabulary = this.vocabularyService.showList();
        model.addAttribute("vocabulary", vocabulary);
        return "index";
    }

    @PostMapping("")
    public String translate(@RequestParam String keyWord, Model model) {
        Map<String, String> vocabulary = this.vocabularyService.showList();
        String result = this.vocabularyService.search(keyWord);
        model.addAttribute("result", result);
        model.addAttribute("keyWord", keyWord);
        model.addAttribute("vocabulary", vocabulary);
        return "index";
    }
}
