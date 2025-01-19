package com.scaler.ecommerceproject.repository;

import com.scaler.ecommerceproject.model.Product;
import com.scaler.ecommerceproject.repository.projections.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findById(long id);
    Product findByDescription(String description);

    Product findByTitle(String title);

    Product save(Product product);

    //Implement HQL
    //List of products based on the given category
    @Query("Select p from Product  p where p.category.id=:categoryId")
    List<Product> getProductByCategoryId(@Param("categoryId") Long categoryId);

    //Implement Native Query
    //List of products based on the given category
    @Query(value = "Select * from product  p where p.category_id=:categoryId",nativeQuery = true)
    List<Product> getProductByCategoryIdNativeQuery(@Param("categoryId") Long categoryId);

    //Implement using Projection
    //List of products based on the given category
    @Query("Select p.id as id, p.title as title from Product  p where p.category.id=:categoryId")
    List<ProductProjection> getProductByCategoryIdUsingProjection(@Param("categoryId") Long categoryId);
}
