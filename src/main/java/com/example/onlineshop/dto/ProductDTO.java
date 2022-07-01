package com.example.onlineshop.dto;

import com.example.onlineshop.model.Product;
import lombok.Value;

@Value
public class ProductDTO {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private Long category;

    public Product toProduct(long id) {
        return new Product(id, title, description, price, category);
    }

    public static ProductDTO from(Product p) {
        return new ProductDTO(p.id(), p.title(), p.description(), p.price(), p.categoryId());
    }
}
