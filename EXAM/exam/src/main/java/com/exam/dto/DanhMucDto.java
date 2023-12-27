package com.exam.dto;


public class DanhMucDto {

    private int id;
    private String tenDanhMuc;

    public DanhMucDto() {
    }

    public DanhMucDto(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public DanhMucDto(int id, String tenDanhMuc) {
        this.id = id;
        this.tenDanhMuc = tenDanhMuc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }
}


