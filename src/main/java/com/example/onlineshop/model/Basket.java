package com.example.onlineshop.model;

import java.util.List;

public record Basket (long id, List<BasketItem> basketItems) {
}
