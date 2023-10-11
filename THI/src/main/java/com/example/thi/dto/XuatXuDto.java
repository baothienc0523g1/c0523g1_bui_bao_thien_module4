package com.example.thi.dto;

import javax.validation.constraints.NotBlank;

public class XuatXuDto {
    private int ma;
    @NotBlank(message = "Khong de trong!")
    private String xuatXu;

    public XuatXuDto() {
    }

    public XuatXuDto(int ma, String xuatXu) {
        this.ma = ma;
        this.xuatXu = xuatXu;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }
}
