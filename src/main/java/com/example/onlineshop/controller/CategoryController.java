package com.example.onlineshop.controller;

import com.example.onlineshop.model.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @GetMapping(path = {"", "/", "/all"})
    public List<Category> getCategories() {
        return List.of(
                new Category(5L, 1L, "RTV"),
                new Category(6L, 1L, "AGD")
        );
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable(name = "id") Long categoryId) {
        return new Category(categoryId, 1L, "Cat:categoryId" + categoryId);
    }
}
