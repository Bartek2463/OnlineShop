package com.example.onlineshop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Deprecated(since = "2022-06-26, only for check if all stuff works")
public class TestController {

    @GetMapping
    public Greeting sayHello() {
        return new Greeting("Jan", "Hejka");
    }


    record Greeting(String name, String greet) {

        public String greet() {
            return name + " " + greet;
        }
    }


}
