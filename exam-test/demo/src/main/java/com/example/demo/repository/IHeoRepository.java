package com.example.demo.repository;

import com.example.demo.dto.HeoDtoTruyVan;
import com.example.demo.model.Heo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IHeoRepository extends JpaRepository<Heo, Integer> {

    @Query(value = " select heos.id as id, heos.ma_so_heo as maSoHeo, heos.ngay_nhap_chuong as ngayNhapChuong, " +
            " heos.ngay_xuat_chuong as ngayXuatChuong, heos.trong_luong_nhap_chuong as trongLuongNhapChuong, " +
            "  heos.trong_luong_xuat_chuong as trongLuongXuatChuong, xuat_xu.xuat_xu as xuatXu from heos " +
            " join xuat_xu on heos.xuat_xu_id = xuat_xu.id " +
            " where (xuat_xu.xuat_xu like :timKiem) and (heos.is_deleted = 0) ", nativeQuery = true )
    Page<Heo> findHeosByXuatXu(Pageable pageable, @Param("timKiem") String timKiem);
}
