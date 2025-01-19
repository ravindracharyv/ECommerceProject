package com.scaler.ecommerceproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Category extends BaseModel{
    private String title;
    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    private List<Product> products;
}
