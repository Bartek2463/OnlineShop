package com.example.onlineshop.service;

import com.example.onlineshop.dto.CategoryDTO;
import com.example.onlineshop.model.Category;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CategoryService {

    private AtomicLong index = new AtomicLong(0);

     List<Category> categories = new LinkedList<>() {
        {
//            add(new Category(nextIdx(), 1L, "AGD"));
//            add(new Category(nextIdx(), 1L, "Komputery"));
//            add(new Category(nextIdx(), 1l, "Smartfony"));
//            add(new Category(nextIdx(), 1l, "TV i Audio"));
        }
    };

    private long nextIdx() {
        return index.incrementAndGet();
    }

    public List<Category> getCategories() {
        return categories;
    }

    public Category getCategoryById(Long id) {
        return categories.get(id.intValue() - 1);
    }

    public Long addCategory(CategoryDTO dto) {
        System.out.println(dto);
        Category newCategory = dto.toCategory(nextIdx());
        categories.add(newCategory);
        return newCategory.id();
    }


}
