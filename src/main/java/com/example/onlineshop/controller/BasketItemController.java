package com.example.onlineshop.controller;

import com.example.onlineshop.dto.BasketItemDTO;
import com.example.onlineshop.model.BasketItem;
import com.example.onlineshop.service.BasketItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/basketItem")
public class BasketItemController {
    private BasketItemService service;

    public BasketItemController(BasketItemService service) {
        this.service = service;
    }

    @GetMapping
    public List<BasketItem> getBasketItems() {
        return service.getBasketItems();
    }

    @GetMapping("/{id}")
    public BasketItem getBasketItem(@PathVariable Long id) {
        return service.getItemBy(id);
    }

    @PostMapping()
    public Long addBasketItem(@RequestBody BasketItemDTO dto) {
        return service.addItem(dto);
    }
}
