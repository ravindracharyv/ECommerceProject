package com.scaler.ecommerceproject.controller;

import com.scaler.ecommerceproject.model.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    //create a new Product
    @RequestMapping(value = "/products" , method = RequestMethod.POST)
    public void createProduct(Product product) {

    }

    //Get the product using product id
    public Product getProduct(Long id) {
        return null;
    }

    public void updateProduct(Product product) {

    }

    public void deleteProduct(Product product) {

    }

}
