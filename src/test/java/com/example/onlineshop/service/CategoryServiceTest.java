package com.example.onlineshop.service;

import com.example.onlineshop.dto.CategoryDTO;
import com.example.onlineshop.model.Category;
import com.example.onlineshop.repository.CategoryRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
class CategoryServiceTest {


    @InjectMocks
    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    @Before
    public void init(){
        categoryRepository.findAll().
    }


    private List<Category>pepareMockDate() {
        List<Category> categories = new LinkedList<>();
        categories.add(new Category(1l, null, "Inne"));
        categories.add(new com.example.onlineshop.model.Category(1l, new Category(1l, null, "Inne"), "AGD"));
        categories.add(new com.example.onlineshop.model.Category(2l, new Category(1l, null, "Inne"), "Komputery"));
        categories.add(new com.example.onlineshop.model.Category(3l, new Category(1l, null, "Inne"), "Smartfony"));
        categories.add(new Category(4l, new Category(1l, null, "Inne"), "TV i Audio"));
    return categories;
    }







}






