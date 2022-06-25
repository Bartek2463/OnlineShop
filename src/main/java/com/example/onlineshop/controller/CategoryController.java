package com.example.onlineshop.controller;

import com.example.onlineshop.dto.CategoryDTO;
import com.example.onlineshop.model.Category;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;


import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Controller
@RestController
@RequestMapping("/category")
public class CategoryController {

    private AtomicLong index = new AtomicLong(0);


    private List<Category> categories = new LinkedList<>() {
        {
            add(new Category(nextIdx(), null, "AGD"));
            add(new Category(nextIdx(), 1L, "Komputery"));
            add(new Category(nextIdx(), 1l, "Smartfony"));
            add(new Category(nextIdx(), 1l, "TV i Audio"));
        }
    };

    @GetMapping(path = {"/all"})
    public List<Category> getCategories() {
        return categories;
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable Long id) {
        return getCategories().get(id.intValue() - 1);
    }


    @PostMapping("/add")
    public Long addCategory(@RequestBody CategoryDTO dto) {
        System.out.println(dto);
        Category newCategory = dto.toCategory(nextIdx());
        categories.add(newCategory);
        return newCategory.id();
    }



    private long nextIdx() {
        return index.incrementAndGet();
    }


}

