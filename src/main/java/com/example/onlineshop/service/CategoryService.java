package com.example.onlineshop.service;

import com.example.onlineshop.model.Category;
import com.example.onlineshop.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
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

    public Category addCategory(Category category) {
        ;

        return categories.save(category);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        Category category = new Category(1l, null, "Inne");
        addCategory(new Category(null, category, "AGD"));
        addCategory(new Category(null, category, "RTV"));
        addCategory(new Category(null, category, "Telephones"));
        addCategory(new Category(null, category, "Akcesories"));


    }


}
