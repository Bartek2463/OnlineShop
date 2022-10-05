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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

//    @Test
//    @DisplayName("Should create one particulr entry")
//    void shouldCreateOneProduct() throws Exception {
//        this.mockMvc.perform(post("/product")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("""
//                                {"title" : "title","description" : "desc","price": "2400.0","category" : "1"}
//                                """))
//                .andDo(print())
//                .andExpect(status().isCreated());
//    }

//    @Test
//    @DisplayName("Should return http code 400 when json is bad")
//    void shouldPostClassBlockThenHttpError400() throws Exception {
//        this.mockMvc
//                .perform(post("/product")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("""
//                                {"id":"title":"description":"price":"categoryId"}
//                                               """))
//                .andDo(print())
//                .andExpect(status().is4xxClientError()); // po utworzeniu zasobu nie zwracasz go, więc reszta sprawdzania nie ma sensu
//    }

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
    @DisplayName("Should edit one particular entry")
    void shouldEditOneProduct() throws Exception {
        var id = 1;
        var url = "/product/" + id;
        mockMvc.perform(put(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"title" : "title","description" : "desc","price": "2400.0","category" : "1"}
                                """))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should delete one particular  entry")
    void shouldDeleteOneProduct() throws Exception {
        var id = 1;
        var url = "/product/" + id;
        mockMvc.perform(delete(url)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Sholud return list products for category ")
    void shouldListProductsForCategory() throws Exception {
        //given
        var categoryId = 1;
        var url = "/product/category/" + categoryId;
        //when
        mockMvc.perform(get(url))
                //then
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].categoryId").isNotEmpty())
                .andExpect(jsonPath("$[0].id").exists())
                .andExpect(jsonPath("$[0].title").exists())
                .andExpect(jsonPath("$[0].description").exists())
                .andExpect(jsonPath("$[0].price").exists())
                .andExpect(jsonPath("$[0].price").exists())
                .andExpect(jsonPath("$[0].categoryId").exists());
    }
}
