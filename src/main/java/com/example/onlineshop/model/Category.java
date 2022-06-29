package com.example.onlineshop.model;

import java.util.List;

public record Category(Long id, Long parentId, String name) {

    public String category() {
        return "id  " + id + "parentid" + parentId + "Name" + name ;
    }
}
