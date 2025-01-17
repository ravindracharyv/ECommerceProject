package com.scaler.ecommerceproject.repository;

import com.scaler.ecommerceproject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByDescription(String description);

    Product findByTitle(String title);

    Product save(Product product);
}
