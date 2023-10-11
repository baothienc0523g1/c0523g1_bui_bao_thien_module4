package com.example.demo.service;

import com.example.demo.dto.HeoDtoTruyVan;
import com.example.demo.model.Heo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IHeoService {
    Page<Heo> heoList(Pageable pageable, String timKiem);

    void add(Heo heo);
}
