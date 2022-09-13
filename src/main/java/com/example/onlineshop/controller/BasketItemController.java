package com.example.onlineshop.controller;

import com.example.onlineshop.dto.BasketItemDTO;
import com.example.onlineshop.model.BasketItem;
import com.example.onlineshop.service.BasketItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/basketItem")
public class BasketItemController {
    private BasketItemService service;


}
