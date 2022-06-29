package com.example.onlineshop.controller;

import com.example.onlineshop.OnlineShopApplicationTests;
import com.example.onlineshop.dto.CategoryDTO;
import com.example.onlineshop.model.Category;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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
                .andExpect(jsonPath("$[0].parentId").exists())
                .andExpect(jsonPath("$[0].name").exists());

    }

    @Test
    @DisplayName("Sholud return one entry ")
    void shouldReturnOneCategory() throws Exception {
        //given
        var id = 1;
        var url = "/category/" + id;

        mockMvc.perform(get(url))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.parentId").exists())
                .andExpect(jsonPath("$.name").exists());

    }

    @Test
    @DisplayName("check data for add categry ")
    void sholudCreateCategory() throws Exception {
        var url = "/category";
        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":\"null\",\"parentId\":\"1\",\"name\":\"Inne\"}"))
                .andDo(print())
                .andExpect(status().isOk());

    }
}