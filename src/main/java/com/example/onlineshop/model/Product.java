package com.example.onlineshop.model;

public record Product(Long id, String title, String description, Double price,Long categoryId) {

//    @Override
//    public String toString(){
//        return "id" + id + "Title" + title + "Description" + description + "Price" + price + categoryId;
//    }
}
