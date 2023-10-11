package com.example.thi.model;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Entity
public class Heo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ma;
    @Column(name = "ma_heo", unique = true)
    private String maHeo;
    @Column(columnDefinition = "DATE")
    private String ngayNhap;
    private double trongLuongNhap;
    @Column(columnDefinition = "DATE")
    private String ngayXuat;
    private double trongLuongXuat;
    private String tinhTrang;
    @Column(name = "xoa",columnDefinition = "boolean default false")
    private boolean xoa;
    @ManyToOne
    @JoinColumn(name = "maXuatXu", referencedColumnName = "ma")
    private XuatXu xuatXu;

    public Heo() {
    }

    public Heo(int ma, String maHeo, String ngayNhap, double trongLuongNhap, String ngayXuat, double trongLuongXuat, String tinhTrang, boolean xoa, XuatXu xuatXu) {
        this.ma = ma;
        this.maHeo = maHeo;
        this.ngayNhap = ngayNhap;
        this.trongLuongNhap = trongLuongNhap;
        this.ngayXuat = ngayXuat;
        this.trongLuongXuat = trongLuongXuat;
        this.tinhTrang = tinhTrang;
        this.xoa = xoa;
        this.xuatXu = xuatXu;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public double getTrongLuongNhap() {
        return trongLuongNhap;
    }

    public void setTrongLuongNhap(double trongLuongNhap) {
        this.trongLuongNhap = trongLuongNhap;
    }

    public String getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(String ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public double getTrongLuongXuat() {
        return trongLuongXuat;
    }

    public void setTrongLuongXuat(double trongLuongXuat) {
        this.trongLuongXuat = trongLuongXuat;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public XuatXu getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(XuatXu xuatXu) {
        this.xuatXu = xuatXu;
    }

    public boolean isXoa() {
        return xoa;
    }

    public void setXoa(boolean xoa) {
        this.xoa = xoa;
    }

    public String getMaHeo() {
        return maHeo;
    }

    public void setMaHeo(String maHeo) {
        this.maHeo = maHeo;
    }
}
