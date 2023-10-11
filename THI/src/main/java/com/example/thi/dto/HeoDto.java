package com.example.thi.dto;

import com.example.thi.model.XuatXu;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class HeoDto {
    private int ma;
    @NotBlank(message = "Khong de trong!")
    private String maHeo;
    @NotBlank(message = "Khong de trong!")
    private String ngayNhap;
    @Min(value = 1, message = "Heo nhẹ qua!")
    private double trongLuongNhap;
    @NotBlank(message = "Khong de trong!")
    private String ngayXuat;
    @Min(value = 1, message = "Heo nhẹ qua!")
    private double trongLuongXuat;
    @NotBlank(message = "Khong de trong!")
    private String tinhTrang;

    private boolean xoa;
    private XuatXu xuatXu;

    public HeoDto() {
    }

    public HeoDto(int ma, String maHeo, String ngayNhap, double trongLuongNhap, String ngayXuat, double trongLuongXuat, String tinhTrang, boolean xoa, XuatXu xuatXu) {
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

    public boolean isXoa() {
        return xoa;
    }

    public void setXoa(boolean xoa) {
        this.xoa = xoa;
    }

    public XuatXu getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(XuatXu xuatXu) {
        this.xuatXu = xuatXu;
    }

    public String getMaHeo() {
        return maHeo;
    }

    public void setMaHeo(String maHeo) {
        this.maHeo = maHeo;
    }
}
