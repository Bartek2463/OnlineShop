package com.example.onlineshop.controller;

import com.example.onlineshop.OnlineShopApplicationTests;
import com.example.onlineshop.model.BasketItem;
import com.example.onlineshop.service.BasketItemService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class BasketItemControllerTest extends OnlineShopApplicationTests {

    @Mock
    BasketItemService service;

    @Test
    @DisplayName("Should return list of items, at least one entry")
    void shouldReturnListOfItems() throws Exception {
        //given
        var url = "/basketItem";
        //when
        /*when(service.getBasketItems())
                .thenReturn(
                        List.of(
                                new BasketItem(1L, 1L, 10L, 10.0, 10L)
                        )
                );*/
        mockMvc.perform(get(url))
                //then
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].id").isNotEmpty())
                .andExpect(jsonPath("$[0].id").exists())
                .andExpect(jsonPath("$[0].productId").exists())
                .andExpect(jsonPath("$[0].quantity").exists())
                .andExpect(jsonPath("$[0].price").exists())
                .andExpect(jsonPath("$[0].value").exists());
    }

    @Test
    @DisplayName("Should return one particular entry")
    void shouldReturnOneItem() throws Exception {
        //given
        var id = 1;
        var url = "/basketItem/" + id;
        //when
        mockMvc.perform(get(url))
                //then
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.productId").exists())
                .andExpect(jsonPath("$.quantity").exists())
                .andExpect(jsonPath("$.price").exists())
                .andExpect(jsonPath("$.value").exists());
    }

}
