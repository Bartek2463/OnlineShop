package com.example.onlineshop.service;

import com.example.onlineshop.dto.BasketItemDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.util.Assert;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BasketItemServiceTest {

    private static Stream<Arguments> dataProviderForCalculateValue() {
        return Stream.of(
                Arguments.of(6, 2, 12),
                Arguments.of(8, 4, 32),
                Arguments.of(4, 2, 8)
        );
    }


    @ParameterizedTest
    @MethodSource("dataProviderForCalculateValue")
    @DisplayName("Should return proper calculated value")
    void shouldReturnCalculatedValue(int firstNumber, int secondNumber, double expectedResult){
        //given
        BasketItemService basketItemService = new BasketItemService();
        //when
        double result = basketItemService.calculateValue(firstNumber,secondNumber);
        //then
        assertThat(result).isEqualTo(expectedResult);

    }

    @Test
    @DisplayName("Should return list")
    void shouldReturnList(){
        //given
        BasketItemService basketItemService = new BasketItemService();
        //when
        //then
        assertFalse(basketItemService.getBasketItems().isEmpty());
    }

    @Test
    @DisplayName("should add new item to basket, then return valid id")
    void shouldAddNewItem(){
        //given
        BasketItemService basketItemService = new BasketItemService();
        // when
        var id = basketItemService.addItem(new BasketItemDTO(1L,4L,2.0,10.0));
        // then
        assertTrue(id > 0, "Id should be positive number");
    }
}