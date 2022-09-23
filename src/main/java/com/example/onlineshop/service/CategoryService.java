package com.example.onlineshop.service;

import com.example.onlineshop.model.Category;
import com.example.onlineshop.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

private CategoryRepository categories;

    public List<Category> getCategories() {
        return categories.findAll();
    }

    public Long getCategoryById(Long id) {
        return categories.findById(id).orElse(null).getId();
    }

    public Category addCategory(Category category) {;

        return categories.save(category);
    }


}
