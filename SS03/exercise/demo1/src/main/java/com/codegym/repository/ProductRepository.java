package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> products = new LinkedList<>();
    private static int id;

    static {
        products.add(new Product(1, "iPhone 6", 5000.0, "Cellphone", "Apple"));
        products.add(new Product(2, "Samsung Galaxy S21", 7000.0, "Cellphone", "Samsung"));
        products.add(new Product(3, "iPad Pro", 8000.0, "Tablet", "Apple"));
        products.add(new Product(4, "Apple Watch 3", 3000.0, "Smart Watch", "Apple"));
        products.add(new Product(5, "Nokia N79", 25000.0, "Legend", "Nokia"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void create(Product product) {
        products.add(product);
    }

    @Override
    public void update(int id, Product product) {
        for (int i = 0; i < products.size(); i++) {
            int existId = products.get(i).getId();
            Product temp = products.get(i);
            if (id == existId) {
                temp.setName(product.getName());
                temp.setPrice(product.getPrice());
                temp.setDescription(product.getDescription());
                temp.setBrand(product.getBrand());
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < products.size(); i++) {
            int existId = products.get(i).getId();
            if (id == existId) {
                products.remove(id);
                break;
            }
        }
    }

    @Override
    public Product productDetail(int id) {
        for (int i = 0; i < products.size(); i++) {
            int existId = products.get(i).getId();
            if (id == existId) {
                return products.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> temp = null;
        for (int i = 0; i < products.size(); i++) {
            String existName = products.get(i).getName().toLowerCase();
            if (existName.contains(name.toLowerCase())) {
                temp = new ArrayList<>();
                temp.add(products.get(i));
            }
        }
        return temp;
    }

    @Override
    public Product findById(int id) {
        for (int i = 0; i < products.size(); i++) {
            int existId = products.get(i).getId();
            if (existId == id) {
                return products.get(i);
            }
        }
        return null;
    }
}
