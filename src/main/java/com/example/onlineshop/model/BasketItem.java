package com.example.onlineshop.model;

import lombok.Data;
import lombok.Getter;

@Getter
public class BasketItem {

    public BasketItem(long id, long productId, long quantity, double price) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.value = calculateValue(quantity, price);
    }

    long id;
    long productId;
    long quantity;
    double price;
    double value;

    private double calculateValue(long quantity, double price) {
        return quantity * price;
    }

}
