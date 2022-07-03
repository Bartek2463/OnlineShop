package com.example.onlineshop.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class BasketItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //
    private Long productId;
    @Column(name = "QUANTITY")
    private Long quantity;
    //
    private Double price;
    @Column(name = "VALUE")
    private Double value;

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
