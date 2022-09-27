package com.example.onlineshop.dto;

import com.example.onlineshop.model.Category;
import lombok.Value;

import java.util.Optional;

@Value
public class CategoryDTO {
    Long id;
    Long parentId;
    String name;

    public Category toCategory(Long id, Category parent){
        return  new Category(id,parent,name);
    }

    public static CategoryDTO from(Category p) {
        return new CategoryDTO (p.getId(), p.getParent().getId(),p.getName());
    }
}
