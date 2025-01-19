package com.scaler.ecommerceproject.service;

import com.scaler.ecommerceproject.exceptions.ProductNotFoundException;
import com.scaler.ecommerceproject.model.Category;
import com.scaler.ecommerceproject.model.Product;
import com.scaler.ecommerceproject.repository.CategoryRepository;
import com.scaler.ecommerceproject.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(long id) throws ProductNotFoundException {
        Optional<Product> P= productRepository.findById(id);
        if(P.isPresent()){
            return P.get();
        }
        else{
            throw new ProductNotFoundException("Product Not Found with ID :"+ id);
        }
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products=productRepository.findAll();
        return products;
    }

    @Override
    public Product createProduct(Long id, String title, String description, Double price, String category, String image) {
        Product product=new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(image);
        Optional<Category> categoryBO= categoryRepository.findByTitle(category);
        if(categoryBO.isEmpty()){
            Category newCategoryBO =new Category();
            newCategoryBO.setTitle(category);
            categoryRepository.save(newCategoryBO);
            product.setCategory(newCategoryBO);
        }else{
            Category currentCategory=categoryBO.get();
            product.setCategory(currentCategory);
        }
        Product savedProduct= productRepository.save(product);
        return savedProduct;
    }

    @Override
    public Product updateProduct(long id, Product product) throws ProductNotFoundException {
        return null;
    }

    @Override
    public Product deleteProduct(long id) throws ProductNotFoundException {
        return null;
    }
}
