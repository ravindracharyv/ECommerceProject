package com.scaler.ecommerceproject.repository.projections;


public interface ProductProjection {
    String getName();
    Long getId();
    String getDescription();
    Double getPrice();
    String getImage();
    String getCategory();
}
