package com.example.onlineshop.controller;

import com.example.onlineshop.dto.CategoryDTO;
import com.example.onlineshop.model.Category;

import com.example.onlineshop.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    public ResponseEntity addCategory(@RequestBody CategoryDTO dto) {
        categoryService.addCategory(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}

