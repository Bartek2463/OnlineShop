package com.example.onlineshop.model;

import lombok.Value;

@Value
public class OrderItemDTO {

    private Long id;
    private Long productId;
    private int amount;
    private double price;
    private double value;

    public OrderItem toOrderItem(long id){
        return new OrderItem(id, productId, amount, price, value);
    }

    public static OrderItemDTO from(OrderItem p ){
        return new OrderItemDTO(p.id(),p.productId(), p.amount(), p.price(), p.value() );
    }
}
