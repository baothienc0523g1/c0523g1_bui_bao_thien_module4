package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "heos")
public class Heo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(columnDefinition = "VARCHAR(50)", name = "ma_so_heo", nullable = false)
    private String maSoHeo;
    @Column(columnDefinition = "date", name = "ngay_nhap_chuong", nullable = false)
    private String ngayNhapChuong;
    @Column(columnDefinition = "int", name = "trong_luong_nhap_chuong", nullable = false)
    private Integer trongLuongNhapChuong;
    @Column(columnDefinition = "date", name = "ngay_xuat_chuong")
    private String ngayXuatChuong;
    @Column(columnDefinition = "int", name = "trong_luong_xuat_chuong")
    private Integer trongLuongXuatChuong;

    @ManyToOne
    @JoinColumn(name = "xuat_xu_id", referencedColumnName = "id")
    private XuatXu xuatXu;

    public Heo() {
    }

    public Heo(Integer id, String maSoHeo, String ngayNhapChuong, Integer trongLuongNhapChuong, String ngayXuatChuong,
               Integer trongLuongXuatChuong, XuatXu xuatXu) {
        this.id = id;
        this.maSoHeo = maSoHeo;
        this.ngayNhapChuong = ngayNhapChuong;
        this.trongLuongNhapChuong = trongLuongNhapChuong;
        this.ngayXuatChuong = ngayXuatChuong;
        this.trongLuongXuatChuong = trongLuongXuatChuong;
        this.xuatXu = xuatXu;
    }

    public Heo(String maSoHeo, String ngayNhapChuong, Integer trongLuongNhapChuong, String ngayXuatChuong,
               Integer trongLuongXuatChuong, XuatXu xuatXu) {
        this.maSoHeo = maSoHeo;
        this.ngayNhapChuong = ngayNhapChuong;
        this.trongLuongNhapChuong = trongLuongNhapChuong;
        this.ngayXuatChuong = ngayXuatChuong;
        this.trongLuongXuatChuong = trongLuongXuatChuong;
        this.xuatXu = xuatXu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaSoHeo() {
        return maSoHeo;
    }

    public void setMaSoHeo(String maSoHeo) {
        this.maSoHeo = maSoHeo;
    }

    public String getNgayNhapChuong() {
        return ngayNhapChuong;
    }

    public void setNgayNhapChuong(String ngayNhapChuong) {
        this.ngayNhapChuong = ngayNhapChuong;
    }

    public Integer getTrongLuongNhapChuong() {
        return trongLuongNhapChuong;
    }

    public void setTrongLuongNhapChuong(Integer trongLuongNhapChuong) {
        this.trongLuongNhapChuong = trongLuongNhapChuong;
    }

    public String getNgayXuatChuong() {
        return ngayXuatChuong;
    }

    public void setNgayXuatChuong(String ngayXuatChuong) {
        this.ngayXuatChuong = ngayXuatChuong;
    }

    public Integer getTrongLuongXuatChuong() {
        return trongLuongXuatChuong;
    }

    public void setTrongLuongXuatChuong(Integer trongLuongXuatChuong) {
        this.trongLuongXuatChuong = trongLuongXuatChuong;
    }

    public XuatXu getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(XuatXu xuatXu) {
        this.xuatXu = xuatXu;
    }
}
