package com.example.demo.service.impl;

import com.example.demo.model.XuatXu;
import com.example.demo.repository.IXuatXuRepository;
import com.example.demo.service.IXuatXuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class XuatXuService implements IXuatXuService {
    @Autowired
    private IXuatXuRepository xuatXuRepository;
    @Override
    public List<XuatXu> findAll() {
        return this.xuatXuRepository.findAll();
    }

    @Override
    public void add(XuatXu xuatXu) {
        this.xuatXuRepository.save(xuatXu);
    }
}
