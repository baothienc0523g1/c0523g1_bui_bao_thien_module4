package com.exam.repository;

import com.exam.mode.TinTuc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ITinTucRepository extends JpaRepository<TinTuc, Integer> {

    @Query(value = " select tin_tuc.id, tin_tuc.tieu_de, tin_tuc.noi_dung, " +
            " tin_tuc.ngay_dang_tin, tin_tuc.phong_vien, tin_tuc.id_danh_muc " +
            " from tin_tuc join danh_muc" +
            " on tin_tuc.id_danh_muc = danh_muc.id " +
            " where tin_tuc.trang_thai_xoa = 0  ", nativeQuery = true)
    Page<TinTuc> findALl(Pageable pageable);
}
