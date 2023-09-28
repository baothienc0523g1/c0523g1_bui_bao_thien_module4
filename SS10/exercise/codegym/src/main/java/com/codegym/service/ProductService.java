package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        Product existedProduct = this.productRepository.findById(id).get();
        if (existedProduct != null) {
            return existedProduct;
        } else {
            return null;
        }
    }

    @Override
    public void addProduct(Product product) {
       try {
           this.productRepository.save(product);
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }
    }
}
