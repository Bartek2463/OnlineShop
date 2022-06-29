package com.example.onlineshop.controller;

import com.example.onlineshop.OnlineShopApplicationTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProductControllerTest extends OnlineShopApplicationTests {

    @Test
    @DisplayName("Sholud return list of products, at least of entry")
    void shouldReturnListOffProducts() throws Exception {
        //given
        var url = "/product";
        //when
        mockMvc.perform(get(url))
                //then
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].id").isNotEmpty())
                .andExpect(jsonPath("$[0].id").exists())
                .andExpect(jsonPath("$[0].title").exists())
                .andExpect(jsonPath("$[0].description").exists())
                .andExpect(jsonPath("$[0].price").exists())
                .andExpect(jsonPath("$[0].price").exists())
                .andExpect(jsonPath("$[0].categoryId").exists());

    }

    @Test
    @DisplayName("Should create one add entry")
    void shouldCreateOneProduct() throws Exception {
        var url = "/product";
        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":\"null\",\"title\":\"Telewizor\",\"description\":\"To jest ok\",\"price\":" +
                                "\"2400.0\",\"categoryId\":\"1\"}"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Sholud return one particular entry")
    void shouldReturnOneProduct() throws Exception {
        //given
        var id = 1;
        var url = "/product/" + id;
        //when
        mockMvc.perform(get(url))
                //then
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.title").exists())
                .andExpect(jsonPath("$.description").exists())
                .andExpect(jsonPath("$.price").exists())
                .andExpect(jsonPath("$.price").exists())
                .andExpect(jsonPath("$.categoryId").exists());
    }
    @Test
    @DisplayName("Should create one add entry")
    void shoulEditOneProduct() throws Exception {
 var id = 1;
 var category = 10;
        var url = "/product/"+1;
        mockMvc.perform(put(url)
                        .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                        .content(getArticleInJson(id,category))
                                )
                .andDo(print())
                .andExpect(status().isOk());
    }
    private String getArticleInJson(long id,long category){
        return "{\"id\":\""+id+"\",\"title\":\"Telewizor\",\"description\":\"To jest ok\",\"price\":" +
                "\"2400.0\",\"categoryId\":\""+category+"\"}";
    }



}