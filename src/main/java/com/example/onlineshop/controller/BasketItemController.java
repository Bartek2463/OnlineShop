package com.example.onlineshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class BasketItemController {


    @GetMapping("/getBasketItem")
    public BasketItem getBasketItem() {
        return new BasketItem(7L, 8L, 2, 10, 20);
    }

    @GetMapping("/addBasketItem")
    public String addBasketItem(BasketItem basketItem) {
        return null;
    }


    record BasketItem(long id, long productId, long quantity, double price, double value) {
        public String basketItem() {
            return " id= " + id + " productId= " + productId + " quantity= " + quantity +
                    " price= " + price + " value= " + value;
        }
    }


}
