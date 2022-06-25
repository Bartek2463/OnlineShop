package com.example.onlineshop.model;

import lombok.Value;

@Value
public class BasketItemDTO {
    private long id;
    private long productId;
    private long quantity;
    private double price;
    private double value;

    public BasketItem toBasketItem(long id) {
        return new BasketItem(id, productId, quantity, price, value);
    }

    public static BasketItemDTO from(BasketItem p) {
        return new BasketItemDTO(p.id(), p.productId(), p.quantity(), p.price(), p.value());
    }

}
