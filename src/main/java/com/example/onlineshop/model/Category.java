package com.example.onlineshop.model;

public record Category(Long id, Long parentId, String name) {

    public String category() {
        return "id  " + id + "Parentid" + parentId + "Name" + name;
    }




}
