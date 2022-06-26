package com.example.onlineshop.controller;

import com.example.onlineshop.dto.BasketDTO;
import com.example.onlineshop.model.Basket;
import com.example.onlineshop.model.BasketItem;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/basket")
public class BasketController {


    private AtomicLong index = new AtomicLong(0);

    private final List<BasketItem> basketItems1 = new LinkedList<>() {{
        add(new BasketItem(nextIdx(), 6L, 4, 20, 80));
        add(new BasketItem(nextIdx(), 8L, 3, 10, 30));
        add(new BasketItem(nextIdx(), 4L, 2, 30, 60));
    }};


    private final List<BasketItem> basketItems2 = new LinkedList<>() {{
        add(new BasketItem(nextIdx(), 12L, 1, 5, 5));
        add(new BasketItem(nextIdx(), 13L, 5, 2, 10));
        add(new BasketItem(nextIdx(), 14L, 6, 7, 42));
    }};

    private List<Basket> basket = new LinkedList<Basket>() {{
        add(new Basket(nextIdx(), basketItems1));
        add(new Basket(nextIdx(), basketItems2));
    }};

    @GetMapping
    public List<Basket> getBaskets() {
        return basket;
    }

    @GetMapping("/{id}")
    public Basket getBasket(@PathVariable Long id) {
        return basket.get(id.intValue() - 1);
    }

    @PostMapping
    public long addBasket(@RequestBody BasketDTO dto) {
        System.out.println(dto);
        Basket newBasket = dto.toBasket(nextIdx());
        basket.add(newBasket);

        return newBasket.id();
    }

    private long nextIdx() {
        return index.incrementAndGet();
    }
}
