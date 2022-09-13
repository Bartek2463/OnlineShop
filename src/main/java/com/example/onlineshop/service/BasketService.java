package com.example.onlineshop.service;

import com.example.onlineshop.dto.BasketDTO;
import com.example.onlineshop.model.Basket;
import com.example.onlineshop.model.BasketItem;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service

public class BasketService {

    private AtomicLong index = new AtomicLong(0);

    private final List<BasketItem> basketItems1 = new LinkedList<>() {{


    }};


    private final List<BasketItem> basketItems2 = new LinkedList<>() {{

    }};

    private List<Basket> basket = new LinkedList<Basket>() {{
        add(new Basket(1, basketItems1));
        add(new Basket(2, basketItems2));
    }};

    public List<Basket> getBasket() {
        return basket;
    }

    private long nextIdx() {
        return index.incrementAndGet();
    }


    public Basket getBasketBy(Long id) {
        return basket.get(id.intValue() - 1);
    }

    public long addBasket(BasketDTO dto) {
        System.out.println(dto);
        Basket newBasket = dto.toBasket(nextIdx());
        basket.add(newBasket);
        return newBasket.id();
    }
}
