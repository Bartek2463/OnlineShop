package com.example.onlineshop.dto;

import com.example.onlineshop.model.Category;
import com.example.onlineshop.model.Product;
import lombok.Value;

@Value
public class CategoryDTO {
    Long id;
    Long parentId;
    String name;

    public Category toCategory(long id){
        return  new Category(id,parentId,name);
    }

    public static CategoryDTO from(Category p) {
        return new CategoryDTO (p.id(), p.parentId(),p.name());
    }
}
