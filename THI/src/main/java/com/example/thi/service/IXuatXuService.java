package com.example.thi.service;

import com.example.thi.model.XuatXu;

import java.util.List;

public interface IXuatXuService {
    List<XuatXu> danhSachXuatXu();
    XuatXu findById(int ma);
}
