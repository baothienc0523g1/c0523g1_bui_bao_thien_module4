package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void create(Product product);
    void update(int id, Product product);
    void delete(int id);
    Product productDetail(int id);
    List<Product> findByName(String name);
    Product findById(int id);
}
