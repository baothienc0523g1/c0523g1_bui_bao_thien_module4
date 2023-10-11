package com.example.thi.service;

import com.example.thi.model.XuatXu;
import com.example.thi.repository.IXuatXuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XuatXuService implements IXuatXuService{
    @Autowired
    private IXuatXuRepository xuatXuRepository;
    @Override
    public List<XuatXu> danhSachXuatXu() {
        return xuatXuRepository.findAll();
    }

    @Override
    public XuatXu findById(int ma) {
        return xuatXuRepository.findById(ma).get();
    }
}
