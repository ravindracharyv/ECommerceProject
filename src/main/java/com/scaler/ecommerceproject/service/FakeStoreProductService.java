package com.scaler.ecommerceproject.service;

import com.scaler.ecommerceproject.dto.FakeStoreProductDto;
import com.scaler.ecommerceproject.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FakeStoreProductService  implements  ProductService{

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }



    @Override
    public Product getSingleProduct(long id) {
        System.out.println("Inside FakeStore api call here...");
        FakeStoreProductDto fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                        FakeStoreProductDto.class);
        System.out.println(fakeStoreProductDto.toString());
        return fakeStoreProductDto.getProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        FakeStoreProductDto[] listOfProducts= restTemplate.getForObject("https://fakestoreapi.com/products",
                FakeStoreProductDto[].class);
        if(listOfProducts != null) {
            for(FakeStoreProductDto fakeStoreProductDto : listOfProducts){
                products.add(fakeStoreProductDto.getProduct());
            }
        }

        return products;
    }

    @Override
    public Product createProduct(Long id ,String title, String description, Double price, String category,String image) {
        FakeStoreProductDto fakeStoreProductDto=new FakeStoreProductDto();
        fakeStoreProductDto.setId(id);
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setImage(image);

        FakeStoreProductDto response = restTemplate.postForObject("https://fakestoreapi.com/products",
                fakeStoreProductDto,FakeStoreProductDto.class);

        return response.getProduct();
    }

    @Override
    public Product updateProduct(long id, Product product) {
        Product productFromFS = getSingleProduct(id);
        productFromFS.setTitle(product.getTitle());
        productFromFS.setDescription(product.getDescription());
        productFromFS.setPrice(product.getPrice());
        productFromFS.setCategory(product.getCategory());

        return productFromFS;
    }

    @Override
    public Product deleteProduct(long id) {

        Product response = getSingleProduct(id);
        restTemplate.delete("https://fakestoreapi.com/products/" + id);

        return response;

    }


}
