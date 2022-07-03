package com.example.onlineshop.dto;

import com.example.onlineshop.model.Category;
import com.example.onlineshop.model.Product;
import lombok.Value;

@Value
public class CategoryDTO {
    Long id;
    Long parentId;
    String name;

    public Category toCategory(long id,Category parent){
        return  new Category(id,parent,name);
    }

    public static CategoryDTO from(Category p) {
        return new CategoryDTO (p.getId(), p.getParent().getId(),p.getName());
    }
}
