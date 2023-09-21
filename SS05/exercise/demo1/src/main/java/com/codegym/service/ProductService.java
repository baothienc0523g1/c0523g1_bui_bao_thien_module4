package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> showList() {
        return this.productRepository.showList();
    }

    @Override
    public void addProduct(Product product) {
        this.productRepository.addProduct(product);
    }

    @Override
    public boolean removeProduct(int id) {
        Product product = this.productRepository.findById(id);
        if (product != null) {
            this.productRepository.removeProduct(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void adjustProduct(int id, Product product) {
        this.productRepository.adjustProduct(id, product);
    }

    @Override
    public Product findById(int id) {
        return this.productRepository.findById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return this.productRepository.findByName(name);
    }
}
