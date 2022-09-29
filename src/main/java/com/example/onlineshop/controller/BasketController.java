package com.example.onlineshop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
