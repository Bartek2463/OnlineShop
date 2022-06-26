package com.example.onlineshop.model;

import lombok.Data;


public record BasketItem(long id, long productId, long quantity, double price, double value) {


}
