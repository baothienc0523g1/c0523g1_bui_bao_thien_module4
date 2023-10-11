package com.example.thi.service;

import com.example.thi.model.Heo;
import com.example.thi.repository.IHeoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HeoService implements IHeoService{
    @Autowired
    private IHeoRepository heoRepository;
    @Override
    public Page<Heo> danhSachHeo(Pageable pageable, String maHeo, String tinhTrang, String xuatXu) {
        return heoRepository.findAll(pageable,"%"+ maHeo +"%","%"+ tinhTrang +"%","%"+ xuatXu +"%");
    }

    @Override
    public boolean themHeo(Heo heo) {
        Heo heo1 = heoRepository.save(heo);
        return true;
    }

    @Override
    public Heo timHeo(int ma) {
        return heoRepository.findById(ma).get();
    }

    @Override
    public boolean sua(Heo heo) {
        return false;
    }

    @Override
    public boolean xoa(int ma) {
        Heo heo = heoRepository.findById(ma).get();
        heo.setXoa(true);
        heoRepository.save(heo);
        return true;
    }
}
