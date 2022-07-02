package com.example.onlineshop.controller;

import com.example.onlineshop.dto.BasketDTO;
import com.example.onlineshop.model.Basket;
import com.example.onlineshop.model.BasketItem;
import com.example.onlineshop.service.BasketService;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/basket")
public class BasketController {

    private BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @GetMapping
    public List<Basket> getBaskets() {
        return basketService.getBasket();
    }

    @GetMapping("/{id}")
    public Basket getBasket(@PathVariable Long id) {
        return basketService.getBasketBy(id);
    }

    @PostMapping
    public long addBasket(@RequestBody BasketDTO dto) {
        return basketService.addBasket(dto);
    }
}
