package com.example.onlineshop.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class BasketItem {

    public BasketItem() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    //
    long productId;
    @Column(name = "QUANTITY")
    long quantity;
    double price;
    double value;

    public BasketItem(long id, long productId, long quantity, double price) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.value = calculateValue(quantity, price);
    }


    private double calculateValue(long quantity, double price) {
        return quantity * price;
    }

}
