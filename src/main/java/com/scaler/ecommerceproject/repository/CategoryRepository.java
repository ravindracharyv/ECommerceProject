package com.scaler.ecommerceproject.repository;

import com.scaler.ecommerceproject.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findById(long id);
    Optional<Category> findByTitle(String title);
}
