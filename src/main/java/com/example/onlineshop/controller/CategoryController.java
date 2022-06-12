package com.example.onlineshop.controller;

import com.example.onlineshop.model.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @GetMapping(path = {"", "/", "/all"})
    public List<Category> getCategories() {
        return List.of(
                new Category(1L, 1L, "AGD"),
                new Category(2L, 1L, "Komputery"),
                new Category(3l,1l,"Smartfony"),
                new Category(4l,1l,"TV i Audio")
        );
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable(name = "id") Long categoryId,String name) {
        return new Category(categoryId, 1L, name + categoryId);
    }
}
