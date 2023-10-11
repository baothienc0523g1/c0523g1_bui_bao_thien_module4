package com.example.demo.service.impl;

import com.example.demo.dto.HeoDtoTruyVan;
import com.example.demo.model.Heo;
import com.example.demo.repository.IHeoRepository;
import com.example.demo.service.IHeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HeoService implements IHeoService {
    @Autowired
    private IHeoRepository heoRepository;

    @Override
    public Page<Heo> heoList(Pageable pageable, String timKiem) {
        return this.heoRepository.findHeosByXuatXu(pageable, "%" + timKiem + "%");
    }

    @Override
    public void add(Heo heo) {
        try {
            this.heoRepository.save(heo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
