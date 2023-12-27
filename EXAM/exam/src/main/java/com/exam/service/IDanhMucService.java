package com.exam.service;

import com.exam.mode.DanhMuc;

import java.util.List;

public interface IDanhMucService {
    List<DanhMuc> danhSachDanhMuc();

    void add(DanhMuc danhMuc);
}
