package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> showList();

    void addProduct(Product product);

    void removeProduct(int id);

    void adjustProduct(int id, Product product);

    Product productDetail(int id);

    Product findById(int id);

    List<Product> findByName(String name);
}
