package com.scaler.ecommerceproject.controller;

import com.scaler.ecommerceproject.dto.ErrorDto;
import com.scaler.ecommerceproject.exceptions.ProductNotFoundException;
import com.scaler.ecommerceproject.model.Product;
import com.scaler.ecommerceproject.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    //create a new Product
    @RequestMapping(value = "/products" , method = RequestMethod.POST)
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product.getId(),product.getTitle(),
                product.getDescription(),product.getPrice(),
                product.getCategory().getTitle(),product.getImageUrl());
    }

    //Get the product using product id
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        System.out.println("Starting the api call here...");
        Product prod= productService.getSingleProduct(id);
        System.out.println("Ending the api call here...");
        return prod;
    }

    @PostMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) throws ProductNotFoundException {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/products/{id}")
    public Product deleteProduct(@PathVariable("id") Long id) throws ProductNotFoundException {
        return productService.deleteProduct(id);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorDto handleProductNotFound(Exception e) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(e.getMessage());
        return errorDto;
    }
}
