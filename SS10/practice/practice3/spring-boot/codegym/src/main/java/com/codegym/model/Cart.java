package com.codegym.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();
    public Cart(){}

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }
    //------------------

    //select item
    private Map.Entry<Product, Integer> selectItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().equals(product.getId())) {
                return entry;
            }
        }
        return null;
    }

    //check item if this item already in cart
    private boolean checkItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return true;
            }
        }
        return false;
    }
    //add new item to cart
    public void addProduct(Product product) {
        if (!checkItemInCart(product)) {
            products.put(product, 1);
        } else {
            int newQuantity = products.get(product) + 1;
            products.put(product, newQuantity);
        }
    }

    // select quantity of all item
    public Integer countProductQuantity() {
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    //count how many product are picked
    public Integer countItemQuantity() {
        return products.size();
    }

    //return price of cart
    public Float countTotalPayment() {
        float payment = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }
    //----------------------------

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }
}
