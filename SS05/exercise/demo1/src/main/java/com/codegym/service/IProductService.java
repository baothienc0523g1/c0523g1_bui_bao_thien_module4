package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> showList();
    void addProduct(Product product);
    boolean removeProduct(int id);
    void adjustProduct(int id, Product product);
    Product findById(int id);
    List<Product> findByName(String name);
}
