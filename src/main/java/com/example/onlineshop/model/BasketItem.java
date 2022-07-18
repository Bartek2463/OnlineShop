package com.example.onlineshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BasketItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //
    private Long productId;
    @Column(name = "QUANTITY")
    private Double quantity;
    //
    private Double price;
    @Column(name = "VALUE")
    private Double value;




    private double calculateValue(long quantity, double price) {
        return quantity * price;
    }

}
