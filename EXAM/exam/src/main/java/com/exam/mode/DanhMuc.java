package com.exam.mode;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "danh_muc")
public class DanhMuc {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "ten_danh_muc", columnDefinition = "VARCHAR (100)", nullable = false)
    private String tenDanhMuc;

    public DanhMuc() {
    }

    public DanhMuc(int id, String tenDanhMuc) {
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
