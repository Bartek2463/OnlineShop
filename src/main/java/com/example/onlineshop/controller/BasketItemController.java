package com.example.onlineshop.controller;

import com.example.onlineshop.model.BasketItem;
import com.example.onlineshop.model.BasketItemDTO;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/basketItem")
public class BasketItemController {

    public BasketItemController(){}

    private AtomicLong index = new AtomicLong(0);

    private List<BasketItem> basketItems = new LinkedList<>()
    {{
            add(new BasketItem(nextIdx(), 6L, 4, 20, 11));
            add(new BasketItem(nextIdx(), 8L, 3, 10, 11));
            add(new BasketItem(nextIdx(), 4L, 2, 30, 11));

        }};

    private long nextIdx() {
        return index.incrementAndGet();
    }

    private double calculateValue(long quantity, double price) {
        return quantity * price;
    }

    @GetMapping
    public List<BasketItem> getBasketItems() {
        return basketItems;
    }

    @GetMapping("/{id}")
    public BasketItem getBasketItems(@PathVariable Long id) {
        return basketItems.get(id.intValue() - 1);
    }

    @PostMapping()
    public Long addBasketItem(@RequestBody BasketItemDTO dto) {
        System.out.println(dto);
        BasketItem newBasketItem = dto.toBasketItem(nextIdx());
        basketItems.add(newBasketItem);

        return newBasketItem.id();
    }


}
