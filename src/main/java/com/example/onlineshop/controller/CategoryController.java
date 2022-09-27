package com.example.onlineshop.controller;

import com.example.onlineshop.dto.CategoryDTO;
import com.example.onlineshop.model.Category;

import com.example.onlineshop.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;



//    @GetMapping
//    public List<Category> getCategories() {
//        return categoryService.getCategories();
//    }
//
//    @GetMapping("/{id}")
//    public Long getCategory(@PathVariable Long id) {
//        return categoryService.getCategoryById(id);
//    }
//
//    @PostMapping
//    public ResponseEntity addCategory(@RequestBody Category category) {
//        categoryService.addCategory(category);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }


}

