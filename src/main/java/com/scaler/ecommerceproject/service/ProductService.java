package com.scaler.ecommerceproject.service;

import com.scaler.ecommerceproject.exceptions.ProductNotFoundException;
import com.scaler.ecommerceproject.model.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(long id) throws ProductNotFoundException;
    List<Product> getAllProducts();
    Product createProduct(Long id,String title, String description, Double price, String category,String image);
    Product updateProduct(long id, Product product)throws ProductNotFoundException;
    Product deleteProduct(long id) throws ProductNotFoundException;
}
