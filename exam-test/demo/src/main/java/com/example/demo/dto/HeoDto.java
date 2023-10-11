package com.example.demo.dto;


import com.example.demo.model.XuatXu;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;

public class HeoDto implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        HeoDto heoDto = (HeoDto) target;
        if (heoDto.getTrongLuongNhapChuong() <= 0 || heoDto.getTrongLuongXuatChuong() <= 0) {
            errors.rejectValue("trongLuong", null, "Trọng lượng như vậy là sai rồi bro");
        }
    }

    private Integer id;
    @NotBlank(message = "Trường này không được để trống")
    private String maSoHeo;
    @NotBlank(message = "Trường này không được để trống")
    private String ngayNhapChuong;
    private Integer trongLuongNhapChuong;
    @NotBlank(message = "Trường này không được để trống")
    private String ngayXuatChuong;
    private Integer trongLuongXuatChuong;
    private XuatXu xuatxu;

    public HeoDto() {
    }

    public HeoDto(String maSoHeo, String ngayNhapChuong, Integer trongLuongNhapChuong, String ngayXuatChuong,
                  Integer trongLuongXuatChuong, XuatXu xuatxu) {
        this.maSoHeo = maSoHeo;
        this.ngayNhapChuong = ngayNhapChuong;
        this.trongLuongNhapChuong = trongLuongNhapChuong;
        this.ngayXuatChuong = ngayXuatChuong;
        this.trongLuongXuatChuong = trongLuongXuatChuong;
        this.xuatxu = xuatxu;
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

    public XuatXu getXuatxu() {
        return xuatxu;
    }

    public void setXuatxu(XuatXu xuatxu) {
        this.xuatxu = xuatxu;
    }
}
