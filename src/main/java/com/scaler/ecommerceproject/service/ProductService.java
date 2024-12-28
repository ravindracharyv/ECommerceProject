package com.scaler.ecommerceproject.service;

import com.scaler.ecommerceproject.model.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(long id);
    List<Product> getAllProducts();
    Product createProduct(Product product);
}
