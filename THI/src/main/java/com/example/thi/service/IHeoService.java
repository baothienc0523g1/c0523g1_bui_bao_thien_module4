package com.example.thi.service;

import com.example.thi.model.Heo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IHeoService {
    Page<Heo> danhSachHeo(Pageable pageable, String maHeo, String tinhTrang, String xuatXu);
    boolean themHeo(Heo heo);
    Heo timHeo(int ma);
    boolean sua(Heo heo);
    boolean xoa(int ma);
}
