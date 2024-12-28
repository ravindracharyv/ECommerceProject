package com.scaler.ecommerceproject.controller;

import com.scaler.ecommerceproject.model.Product;
import com.scaler.ecommerceproject.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    //create a new Product
    @RequestMapping(value = "/products" , method = RequestMethod.POST)
    public void createProduct(Product product) {

    }

    //Get the product using product id
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        productService.getSingleProduct(id);
        return null;
    }

    public void updateProduct(Product product) {

    }

    public void deleteProduct(Product product) {

    }

}
