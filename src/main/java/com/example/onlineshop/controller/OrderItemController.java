package com.example.onlineshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderItemController {

    @GetMapping
    public OrderItem getOrderItem(){
        return new OrderItem(1L, 2L, 1, 23.99, 23.99);
    }

    record OrderItem(Long id, Long productId, int amout, double price, double value ){
        public String orderItem(){
            return "id " + id + "productId " + productId + "amount " + "price " + price + "value " + value;
        }
    }
}