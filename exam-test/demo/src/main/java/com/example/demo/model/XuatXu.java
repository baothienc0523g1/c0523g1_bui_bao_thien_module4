package com.example.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "xuat_xu")
public class XuatXu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(columnDefinition = "VARCHAR(50)", name = "xuat_xu", nullable = false)
    private String noiXuatXu;

    @OneToMany(mappedBy = "xuatXu")
    private Set<Heo> heos;

    public XuatXu() {
    }

    public XuatXu(Integer id, String noiXuatXu, Set<Heo> heos) {
        this.id = id;
        this.noiXuatXu = noiXuatXu;
        this.heos = heos;
    }

    public XuatXu(String noiXuatXu) {
        this.noiXuatXu = noiXuatXu;
    }

    public XuatXu(Integer id, String noiXuatXu) {
        this.id = id;
        this.noiXuatXu = noiXuatXu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoiXuatXu() {
        return noiXuatXu;
    }

    public void setNoiXuatXu(String noiXuatXu) {
        this.noiXuatXu = noiXuatXu;
    }

    public Set<Heo> getHeos() {
        return heos;
    }

    public void setHeos(Set<Heo> heos) {
        this.heos = heos;
    }
}
