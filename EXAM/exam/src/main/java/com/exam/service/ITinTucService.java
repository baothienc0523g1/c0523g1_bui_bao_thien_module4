package com.exam.service;

import com.exam.mode.DanhMuc;
import com.exam.mode.TinTuc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITinTucService {
    Page<TinTuc> danhSachTinTuc(Pageable pageable);

    void add(TinTuc tinTuc);


    void delete(int id);

    TinTuc findById(int id);
}
