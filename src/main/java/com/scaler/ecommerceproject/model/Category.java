package com.scaler.ecommerceproject.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {
    private Long id;
    private String name;

    public Category() {
    }
    public Category(Long id) {
        this.id = id;
        this.name = name;
    }
}
