package com.example.thi.repository;

import com.example.thi.model.Heo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IHeoRepository extends JpaRepository<Heo, Integer> {
    @Query(value = "select heo.ma, heo.ma_heo, heo.ngay_nhap, heo.ngay_xuat, " +
            "heo.tinh_trang, heo.trong_luong_nhap, heo.trong_luong_xuat, " +
            "heo.xoa, heo.ma_xuat_xu from heo join xuat_xu on heo.ma_xuat_xu = xuat_xu.ma\n" +
            "where heo.ma_heo like :maHeo  and " +
            "heo.tinh_trang like :tinhTrang and " +
            "xuat_xu.xuat_xu like :xuatXu and heo.xoa = 0", nativeQuery = true)
    Page<Heo> findAll(Pageable pageable, @Param("maHeo") String maHeo, @Param("tinhTrang") String tinhTrang, @Param("xuatXu") String xuatXu);

}
