package com.example.onlineshop.controller;

import com.example.onlineshop.OnlineShopApplicationTests;
import com.example.onlineshop.service.BasketService;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
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
public class BasketControllerTest extends OnlineShopApplicationTests {

    @Mock
    BasketService service;

    @Test
    @DisplayName("should return list of baskets, at least one")
    void shouldReturnListOfBaskets() throws Exception {
        //given
        var url = "/basket";


        //when
        mockMvc.perform(get(url))

                //then
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].id").isNotEmpty())
                .andExpect(jsonPath("$[0].id").exists())
                .andExpect(jsonPath("$[0].basketItems").exists());
    }


    @Test
    @DisplayName("should create new basket")
    void shouldCreateNewBasket() throws Exception {
        this.mockMvc.perform(post("/basket")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {"id" : "3", "basketItems" : "basketItems"}
                        """))
                .andDo(print())
                .andExpect(status().isCreated());

    }


    @Test
    @DisplayName("should return entry from given id")
    void shouldReturnEntryFromGivenId() throws Exception {
        // given
        var id = 1;
        var url = "/basket/" + id;

        //when
        mockMvc.perform(get(url))

        //then
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andExpect(jsonPath("$.basketItems").exists());


    }

}
