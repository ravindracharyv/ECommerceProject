package com.scaler.ecommerceproject.repository;

import com.scaler.ecommerceproject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findById(long id);
    Product findByDescription(String description);

    Product findByTitle(String title);

    Product save(Product product);
}
