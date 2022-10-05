package com.example.onlineshop.service;

import com.example.onlineshop.OnlineShopApplicationTests;
import com.example.onlineshop.dto.CategoryDTO;
import com.example.onlineshop.model.Category;
import com.example.onlineshop.repository.CategoryRepository;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest extends OnlineShopApplicationTests {


    private static final CategoryDTO DTO = new CategoryDTO(1l, null, "Inne");
    private static final Category CATEGORY = new Category(1l, null, "Inne");
    private static final Category CATEGORY1 = new Category(1l, CATEGORY, "AGD");

    @InjectMocks
    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    @Before
    public void init(){
        CategoryRepository categoryRepository1= mock(CategoryRepository.class);
        given(categoryRepository1.findAll()).willReturn(getPepareMockDate());
    }
    public List<Category> getPepareMockDate(){
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1l, null, "Inne"));
        categories.add(new Category(2l, new Category(1l, null, "Inne"), "AGD"));
        categories.add(new Category(3l, new Category(1l, null, "Inne"), "Komputery"));
        categories.add(new Category(4l, new Category(1l, null, "Inne"), "Smartfony"));
        categories.add(new Category(5l, new Category(1l, null, "Inne"), "TV i Audio"));
        return categories;
    }



//    @Test
//    @DisplayName("Should return one product")
//    void shouldGetProductById() {
//        when(categoryRepository.findById(any())).thenReturn(Optional.ofNullable(CATEGORY1));
//        Category result = categoryService.findById(1l);
//
//        assertEquals(CATEGORY1, result);
//        assertThat(result).isEqualTo(CATEGORY1);
//    }

    @Test
    @DisplayName("Should Create new Category")
    void shouldCreateNewCategory() {
        when(categoryRepository.save(any())).thenReturn(CATEGORY);

        Category result = categoryService.save(DTO);

        assertEquals(result, CATEGORY);
    }





}






