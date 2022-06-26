package com.example.onlineshop.dto;

import com.example.onlineshop.model.OrderItem;
import lombok.Value;

@Value
public class OrderItemDTO {

    Long id;
    Long productId;
    int amount;
    double price;
    double value;

    public OrderItem toOrderItem(long id){
        return new OrderItem(id, productId, amount, price, value);
    }

    public static OrderItemDTO from(OrderItem p ){
        return new OrderItemDTO(p.id(),p.productId(), p.amount(), p.price(), p.value() );
    }
}
