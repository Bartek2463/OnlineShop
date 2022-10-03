package com.example.onlineshop.service;

import com.example.onlineshop.model.Category;
import com.example.onlineshop.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    private static final Category CATEGORY = new Category(1l,null,"Inne");
    private static final Category CATEGORY1 = new Category(1L,CATEGORY,"AGD");

    @InjectMocks
    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;


//    private List<Category>pepareMockDate() {
//        List<Category> categories = new LinkedList<>();
//        categories.add(new Category(1l, null, "Inne"));
//        categories.add(new com.example.onlineshop.model.Category(1l, new Category(1l, null, "Inne"), "AGD"));
//        categories.add(new com.example.onlineshop.model.Category(2l, new Category(1l, null, "Inne"), "Komputery"));
//        categories.add(new com.example.onlineshop.model.Category(3l, new Category(1l, null, "Inne"), "Smartfony"));
//        categories.add(new Category(4l, new Category(1l, null, "Inne"), "TV i Audio"));
//    return categories;
//    }
    @Test
    void should(){
        Mockito.when(categoryRepository.findById(any())).thenReturn(Optional.ofNullable(CATEGORY));
        Category result = categoryService.findById(1l);

        assertEquals(CATEGORY,result);

    }







}






