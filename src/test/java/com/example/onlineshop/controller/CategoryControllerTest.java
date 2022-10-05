package com.example.onlineshop.controller;

import com.example.onlineshop.OnlineShopApplicationTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class CategoryControllerTest extends OnlineShopApplicationTests {

    @Test
    @DisplayName("Sholud return list of category, at least one entry ")
    void shouldReturnListOfCategory() throws Exception {
        //given
        var url = "/category";

        mockMvc.perform(get(url))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].id").isNotEmpty())
                .andExpect(jsonPath("$[0].id").exists())
                .andExpect(jsonPath("$[1].parent").exists())
                .andExpect(jsonPath("$[0].name").exists());
    }

    @Test
    @DisplayName("Sholud return one entry ")
    void shouldReturnOneCategory() throws Exception {
        //given
        var id = 2;
        var url = "/category/" + id;

        mockMvc.perform(get(url))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.parent").exists())
                .andExpect(jsonPath("$.name").exists());
    }

    @Test
    @DisplayName("Should create new category")
    void shouldPostAddCategoryWithCreated() throws Exception {
        var url = "/category";
        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"id" : 0,"parent" : "1","name" : "Inne"}
                                """))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Should return http code 400 when json is bad")
    void shouldPostAddCategoryThenHttpError400() throws Exception {
        var url = "/category";
        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"id" :"parent" :"name" :}
                                """))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
