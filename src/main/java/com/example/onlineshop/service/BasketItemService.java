package com.example.onlineshop.service;

import com.example.onlineshop.dto.BasketItemDTO;
import com.example.onlineshop.model.BasketItem;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BasketItemService {

    //access to repository
    private final AtomicLong index = new AtomicLong(0);

    private final List<BasketItem> basketItems = new LinkedList<>() {{
        add(new BasketItem(nextIdx(), 6L, 4, 20, 11));
        add(new BasketItem(nextIdx(), 8L, 3, 10, 11));
        add(new BasketItem(nextIdx(), 4L, 2, 30, 11));

    }};

    public List<BasketItem> getBasketItems() {
        return basketItems;
    }

    public BasketItem getItemBy(Long id) {
        return basketItems.get(id.intValue() - 1);
    }

    public Long addItem(BasketItemDTO newItem) {
        BasketItem newBasketItem = newItem.toBasketItem(nextIdx());
        basketItems.add(newBasketItem);
        return newBasketItem.id();
    }

    private long nextIdx() {
        return index.incrementAndGet();
    }
    private double calculateValue(long quantity, double price) {
        return quantity * price;
    }
}
