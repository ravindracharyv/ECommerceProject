package com.scaler.ecommerceproject;

import com.scaler.ecommerceproject.model.Category;
import com.scaler.ecommerceproject.model.Product;
import com.scaler.ecommerceproject.repository.CategoryRepository;
import com.scaler.ecommerceproject.repository.ProductRepository;
import com.scaler.ecommerceproject.repository.projections.ProductProjection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ECommerceProjectApplicationTests {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testQueries(){
        List<Product> allProducts = productRepository.getProductByCategoryIdNativeQuery(1L);
        for (Product product : allProducts) {
            System.out.println(product.toString());
        }
    }

    @Test
    void testQueriesForProductProjection(){
        List<ProductProjection> allProducts = productRepository.getProductByCategoryIdUsingProjection(1L);
        for (ProductProjection product : allProducts) {
            System.out.println(product.getId()+"\t"+product.getName());
        }
    }

    @Test
    void testFetchType(){
        Category category = categoryRepository.findById(1L);
        System.out.println(category.toString());
        List<Product> allProducts = productRepository.getProductByCategoryIdNativeQuery(1L);
        for (Product product : allProducts) {
            System.out.println(product.toString());
        }
    }

    @Test
    void testFetchTypeLazy(){
        List<Category> categoryList = categoryRepository.findByTitleContains("tshirt");
        for (Category category : categoryList) {
            System.out.println(category.toString());
            List<Product> allProducts = productRepository.getProductByCategoryIdNativeQuery(1L);
            for (Product product : allProducts) {
                System.out.println(product.toString());
            }
        }

    }

}
