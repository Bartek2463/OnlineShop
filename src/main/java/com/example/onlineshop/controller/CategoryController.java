package com.example.onlineshop.controller;

import com.example.onlineshop.dto.CategoryDTO;
import com.example.onlineshop.model.Category;

import com.example.onlineshop.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    @GetMapping
    public Iterable<Category> getCategories() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @PostMapping
    public ResponseEntity addCategory(@RequestBody CategoryDTO dto) {
        categoryService.save(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}

