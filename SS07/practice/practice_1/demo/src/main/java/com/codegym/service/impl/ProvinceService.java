package com.codegym.service.impl;

import com.codegym.model.Province;
import com.codegym.repository.IProvinceRepository;
import com.codegym.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProvinceService implements IProvinceService {
    private IProvinceRepository provinceRepository;

    @Autowired
    public ProvinceService(IProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }

    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public void save(Province province) {
        this.provinceRepository.save(province);
    }

    @Override
    public Optional<Province> findById(Integer id) {
        return this.provinceRepository.findById(id);
    }

    @Override
    public void remove(Integer id) {
        provinceRepository.deleteById(id);
    }
}
