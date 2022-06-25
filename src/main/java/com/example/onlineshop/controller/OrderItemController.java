package com.example.onlineshop.controller;

import com.example.onlineshop.model.OrderItem;
import com.example.onlineshop.model.OrderItemDTO;
import com.example.onlineshop.model.Product;
import com.example.onlineshop.model.ProductDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Controller
@RestController
@RequestMapping("/order")
public class OrderItemController {


    public  AtomicLong index = new AtomicLong();
    private long nextId(){
        return index.incrementAndGet();
    }

    private List<OrderItem> orderItems = new LinkedList<>(){
        {
            add(new OrderItem(nextId(), 1l, 3, 2500.0, 400));
            add(new OrderItem(nextId(), 2l, 5, 4500.0, 700));
        }
    };



    @GetMapping("")
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    @GetMapping("/{id}")
    public OrderItem getOrderItem(@PathVariable Long id) {
        return getOrderItems().get(id.intValue() - 1);

    }



    @GetMapping("/product/{productId}")
    public List<OrderItem> orderItems(@PathVariable Long productId) {

        System.out.println("productId = " + productId);
        return getOrderItems().stream().filter(a -> a.productId().equals(productId))
                .collect(Collectors.toList());
    }

    @PostMapping()
    public Long addOrderItem(@RequestBody OrderItemDTO dto) {
        System.out.println(dto);
        OrderItem newOrderItem = dto.toOrderItem(nextId());
        orderItems.add(newOrderItem);
        return  newOrderItem.id();


    }




    }
