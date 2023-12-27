package com.exam.dto;

import com.exam.mode.DanhMuc;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Date;

public class TinTucDto implements Validator {
    private int id;
    @NotBlank(message = "Trường này không được để trống")
    private String tieuDe;
    private String ngayDangTin;
    @NotBlank(message = "Trường này không được để trống")
    private String phongVien;
    private DanhMuc danhMuc;
    @NotBlank(message = "Trường này không được để trống")
    private String noiDung;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
//        TinTucDto tinTucDto = (TinTucDto) target;
//        LocalDate localDate = LocalDate.parse(tinTucDto.getNgayDangTin());
//        LocalDate toDay = LocalDate.now();
//        if (localDate.isBefore(toDay)) {
//            errors.rejectValue("ngayDangTin", null, "Ngày đăng tin không hợp lệ");
//        }
    }


    public TinTucDto(int id, String tieuDe, String ngayDangTin, String phongVien, DanhMuc danhMuc, String noiDung) {
        this.id = id;
        this.tieuDe = tieuDe;
        this.ngayDangTin = ngayDangTin;
        this.phongVien = phongVien;
        this.danhMuc = danhMuc;
        this.noiDung = noiDung;
    }

    public TinTucDto() {
    }

    public TinTucDto(String tieuDe, String ngayDangTin, String phongVien, DanhMuc danhMuc, String noiDung) {
        this.tieuDe = tieuDe;
        this.ngayDangTin = ngayDangTin;
        this.phongVien = phongVien;
        this.danhMuc = danhMuc;
        this.noiDung = noiDung;
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

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }
}
