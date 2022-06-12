package com.example.onlineshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @GetMapping
    public  Category getCategory() {
        return new Category(1L,2L,"RTV");
    }


    record Category(Long id,Long parentId,String name){
        public String category(){
            return "id  "+id +"Parentid"+ parentId +"Name"+ name;
        }
    }


}
