package com.scaler.ecommerceproject.repository;

import com.scaler.ecommerceproject.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findById(long id);
    Category findByTitle(String title);
}
