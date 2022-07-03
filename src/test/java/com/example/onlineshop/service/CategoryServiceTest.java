package com.example.onlineshop.service;

import com.example.onlineshop.OnlineShopApplicationTests;
import com.example.onlineshop.model.Category;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



import static org.assertj.core.api.Assertions.assertThat;


class CategoryServiceTest {




  private CategoryService categoryService = new CategoryService();


   @Test
   @DisplayName("Sholud return list ")
    public void check_All_Categories(){

       assertThat(!categoryService.getCategories().isEmpty());

   }


    }






