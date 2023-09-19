package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;
import java.util.Map;

public interface IProductRepository {
    List<Product> findAll();
    void create(Product product);
    void update(int id, Product product);
    void delete(int id);
    Product productDetail(int id);
    List<Product> findByName(String name);
    Product findById(int id);
}
