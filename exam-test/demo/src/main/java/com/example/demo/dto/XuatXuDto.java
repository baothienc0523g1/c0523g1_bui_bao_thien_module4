package com.example.demo.dto;

public class XuatXuDto {
    private int id;
    private String noiXuatXu;

    public XuatXuDto() {
    }

    public XuatXuDto(int id, String noiXuatXu) {
        this.id = id;
        this.noiXuatXu = noiXuatXu;
    }

    public XuatXuDto(String noiXuatXu) {
        this.noiXuatXu = noiXuatXu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoiXuatXu() {
        return noiXuatXu;
    }

    public void setNoiXuatXu(String noiXuatXu) {
        this.noiXuatXu = noiXuatXu;
    }
}
