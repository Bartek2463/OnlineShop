package com.example.onlineshop.dto;

import com.example.onlineshop.model.BasketItem;
import lombok.Value;

@Value
public class BasketItemDTO {
    private long id;
    private long productId;
    private long quantity;
    private double price;


    public BasketItem toBasketItem(long id) {
        return new BasketItem(id, productId, quantity, price);
    }

    public static BasketItemDTO from(BasketItem p) {
        return new BasketItemDTO(p.getId(), p.getProductId(), p.getQuantity(), p.getPrice());
    }


}