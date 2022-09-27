package com.example.onlineshop.model;

public record OrderItem(Long id, Long productId, int amount, double price, double value ) {

//    @Override
//    public String toString() {
//        return
//                "id=" + id +
//                ", productId=" + productId +
//                ", amout=" + amount +
//                ", price=" + price +
//                ", value=" + value;
//    }
}
