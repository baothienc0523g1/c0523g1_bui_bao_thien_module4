package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> showList() {
        TypedQuery<Product> query = entityManager.createQuery("from Product ", Product.class);
        return query.getResultList();
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> temp = new ArrayList<>();
        List<Product> productList = showList();

        for (int i = 0; i < productList.size(); i++) {
            String existedName = productList.get(i).getName().toLowerCase();
            Product existedProduct = productList.get(i);
            if (existedName.contains(name.toLowerCase())) {
                temp.add(existedProduct);
            }
        }
        return temp;
    }

    @Transactional
    @Override
    public void addProduct(Product product) {
        entityManager.persist(product);
    }

    @Transactional
    @Override
    public void removeProduct(int id) {
        Product productEntity = findById(id);
        entityManager.remove(productEntity);
    }

    @Transactional
    @Override
    public void adjustProduct(int id, Product product) {
        Product productEntity = entityManager.find(Product.class, id);
        productEntity.setName(product.getName());
        productEntity.setCode(product.getCode());
        productEntity.setPrice(product.getPrice());
        productEntity.setDescription(product.getDescription());
        productEntity.setBrand(product.getBrand());
        entityManager.merge(productEntity);
    }


    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }
}
