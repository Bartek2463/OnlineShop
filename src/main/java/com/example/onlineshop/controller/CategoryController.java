package com.example.onlineshop.controller;

import com.example.onlineshop.model.Category;
import com.example.onlineshop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.stream.Collectors;
@Controller
@RestController
@RequestMapping("/category")
public class CategoryController {



    @GetMapping(path = {"", "/", "/all"})
    public List<Category> getCategories() {
        return List.of(
                new Category(1L, 1l, "AGD"),
                new Category(2L, 1L, "Komputery"),
                new Category(3l, 1l, "Smartfony"),
                new Category(4l, 1l, "TV i Audio")
        );
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable Long id) {
        return getCategories().get(id.intValue() - 1);
    }




}

