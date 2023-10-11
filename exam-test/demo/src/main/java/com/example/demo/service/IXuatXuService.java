package com.example.demo.service;

import com.example.demo.model.XuatXu;

import java.util.List;

public interface IXuatXuService {
    List<XuatXu> findAll();
    void add(XuatXu xuatXu);
}
