package com.scaler.ecommerceproject.service;

import com.scaler.ecommerceproject.dto.FakeStoreProductDto;
import com.scaler.ecommerceproject.exceptions.ProductNotFoundException;
import com.scaler.ecommerceproject.model.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService  implements  ProductService{

    private final RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }



    @Override
    public Product getSingleProduct(long id) throws ProductNotFoundException {
        System.out.println("Inside FakeStore api call here...");
        FakeStoreProductDto fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                        FakeStoreProductDto.class);
        if(fakeStoreProductDto == null){
            throw new ProductNotFoundException("Product not found with id " + id);
        }
        //System.out.println(fakeStoreProductDto.toString());
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
        if(response == null){
            return null;
        }
        return response.getProduct();
    }

    @Override
    public Product updateProduct(long id, Product product) throws ProductNotFoundException {
        FakeStoreProductDto fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                        FakeStoreProductDto.class);
        fakeStoreProductDto .setTitle(product.getTitle());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setCategory(product.getCategory().getTitle());
        HttpEntity<FakeStoreProductDto> httpEntity= new HttpEntity<>(fakeStoreProductDto);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.exchange("url", HttpMethod.PUT, httpEntity, FakeStoreProductDto.class);

        return response.getBody().getProduct();
    }

    @Override
    public Product deleteProduct(long id) throws ProductNotFoundException{

        Product response = getSingleProduct(id);
        restTemplate.delete("https://fakestoreapi.com/products/" + id);

        return response;

    }


}
