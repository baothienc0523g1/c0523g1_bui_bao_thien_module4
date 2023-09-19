package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository repository;

    @Override
    public List<Product> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void create(Product product) {
        this.repository.create(product);
    }

    @Override
    public void update(int id, Product product) {
        this.repository.update(id, product);
    }

    @Override
    public void delete(int id) {
        this.repository.delete(id);
    }

    @Override
    public Product productDetail(int id) {
        return this.repository.productDetail(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return this.repository.findByName(name);
    }

    @Override
    public Product findById(int id) {
        return this.repository.findById(id);
    }
}
