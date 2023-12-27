package com.exam.service.impl;

import com.exam.mode.DanhMuc;
import com.exam.repository.IDanhMucRepository;
import com.exam.service.IDanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class DanhMucService implements IDanhMucService {
    @Autowired
    private IDanhMucRepository danhMucRepository;
    @Override
    public List<DanhMuc> danhSachDanhMuc() {
        return this.danhMucRepository.findAll();
    }

    @Transactional
    @Override
    public void add(DanhMuc danhMuc) {
        try {
            this.danhMucRepository.save(danhMuc);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
