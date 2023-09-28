package com.codegym.dto;


import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<ProductDto, Integer> products = new HashMap<>();

    public CartDto() {
    }

    public CartDto(Map<ProductDto, Integer> products) {
        this.products = products;
    }

    //add product to cart
    public void addProduct(ProductDto productDto) {
        if (!products.containsKey(productDto)) {
            products.put(productDto, 1);
        } else {
            int newQuantity = products.get(productDto) + 1;
            products.put(productDto, newQuantity);
        }
    }

    public void removeProduct(ProductDto productDto) {
        try {
            int newQuantity = products.get(productDto) - 1;
            if (newQuantity > 0) {
                products.put(productDto, newQuantity);
            } else {
                products.put(productDto, 1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //check quantity of items
    public Integer countProductQuantity() {
        Integer productQuantity = 0;
        for (Map.Entry<ProductDto, Integer> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    //get price
    public Double getPrice() {
        Double totalPrice = 0.0;
        for (Map.Entry<ProductDto, Integer> entry : products.entrySet()) {
            totalPrice += entry.getKey().getPrice() * entry.getValue();
        }
        return totalPrice;
    }

    public Map<ProductDto, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<ProductDto, Integer> products) {
        this.products = products;
    }
}
