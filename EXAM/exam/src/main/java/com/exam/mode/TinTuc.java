package com.exam.mode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "tin_tuc")
public class TinTuc {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "tieu_de", nullable = false, columnDefinition = "VARCHAR (200)")
    private String tieuDe;

    @Column(name = "ngay_dang_tin", nullable = false, columnDefinition = "date")
    private String ngayDangTin;

    @Column(name = "phong_vien", nullable = false, columnDefinition = "VARCHAR (80)")
    private String phongVien;

    @Column(name = "noi_dung", nullable = false, columnDefinition = "LONGTEXT")
    private String noiDung;
    @ManyToOne
    @JoinColumn(name = "id_danh_muc", referencedColumnName = "id")
    private DanhMuc danhMuc;

    public TinTuc(int id, String tieuDe, String ngayDangTin, String phongVien, String noiDung, DanhMuc danhMuc) {
        this.id = id;
        this.tieuDe = tieuDe;
        this.ngayDangTin = ngayDangTin;
        this.phongVien = phongVien;
        this.noiDung = noiDung;
        this.danhMuc = danhMuc;
    }

    public TinTuc(String tieuDe, String ngayDangTin, String phongVien, String noiDung, DanhMuc danhMuc) {
        this.tieuDe = tieuDe;
        this.ngayDangTin = ngayDangTin;
        this.phongVien = phongVien;
        this.noiDung = noiDung;
        this.danhMuc = danhMuc;
    }

    public TinTuc() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNgayDangTin() {
        return ngayDangTin;
    }

    public void setNgayDangTin(String ngayDangTin) {
        this.ngayDangTin = ngayDangTin;
    }

    public String getPhongVien() {
        return phongVien;
    }

    public void setPhongVien(String phongVien) {
        this.phongVien = phongVien;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
}
