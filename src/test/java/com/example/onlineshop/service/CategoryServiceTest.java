package com.example.onlineshop.service;

import com.example.onlineshop.model.Category;
import com.example.onlineshop.repository.CategoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

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
    @DisplayName("Should return one product")
    void shouldGetProductById(){
        when(categoryRepository.findById(any())).thenReturn(Optional.ofNullable(CATEGORY1));
        Category result = categoryService.findById(1l);

        assertEquals(CATEGORY1,result);
        assertThat(result).isEqualTo(CATEGORY1);
    }

    @Test
    @DisplayName("Sholud return Exception if Category not exists ")
    void shouldThrowExcepionWhenCategoryNotExists(){
        when(categoryRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class,()->categoryService.findById(1l));

        assertThatThrownBy(()->categoryService.findById(1l))
                .isInstanceOf(NoSuchElementException.class);
    }









}






