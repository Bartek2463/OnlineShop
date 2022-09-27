package com.example.onlineshop.controller;

import com.example.onlineshop.dto.BasketDTO;
import com.example.onlineshop.model.Basket;
import com.example.onlineshop.service.BasketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/basket")
public class BasketController {
//
//    private BasketService basketService;
//
//    public BasketController(BasketService basketService) {
//        this.basketService = basketService;
//    }
//
//    @GetMapping
//    public List<Basket> getBaskets() {
//        return basketService.getBasket();
//    }
//
//    @GetMapping("/{id}")
//    public Basket getBasket(@PathVariable Long id) {
//        return basketService.getBasketBy(id);
//    }
//
//    @PostMapping
//    public ResponseEntity addBasket(@RequestBody BasketDTO dto) {
//        basketService.addBasket(dto);
//        return new ResponseEntity(HttpStatus.CREATED);
//    }
}
