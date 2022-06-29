package com.example.onlineshop.controller;


import com.example.onlineshop.model.Product;
import com.example.onlineshop.dto.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Controller
@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {
    private AtomicInteger index = new AtomicInteger(0);
    private List<Product> products = new LinkedList<>() {
        {
            add(new Product(nextIdx(), "Lodówka", "To jest dobra Lodówka wspaniale chłodzi", 2500.0, 1L));
            add(new Product(nextIdx(), "Pralka", "To jest dobra Pralka wspaniale Pierze", 2000.0, 1l));
            add(new Product(nextIdx(), "Piekarnik", "To jest dobry Piekarnik wspaniale Piecze", 1500.0, 1l));
            add(new Product(nextIdx(), "Zmywarka", "To jest dobra Zmywarka wspaniale zmywa", 3500.0, 1l));
            add(new Product(nextIdx(), "PC", "To jest dobry Komputer Stacjonarny wysokie parametry", 4500.0, 2l));
            add(new Product(nextIdx(), "Laptop", "To jest dobry Laptop jest bardzo wytrzymały mechanicznie", 5500.0, 2l));
            add(new Product(nextIdx(), "Monitor", "To jest dobry Monitor o wysokiej rozdzielczości ", 1700.0, 2l));
            add(new Product(nextIdx(), "Klawiatura", "To jest klawiatura mechaniczna", 205.0, 2l));
            add(new Product(nextIdx(), "Telefon", "To jest telefon ma wiele ciekawych funkcji ", 1300.0, 3l));
            add(new Product(nextIdx(), "Tablet", "To jest Tablet jest bardzo odporny na zniszczenia", 1000.0, 3l));
            add(new Product(nextIdx(), "Ładowarka", "To jest Ładowarka unierwsralna do wszystkich telefonów", 100.0, 3l));
            add(new Product(nextIdx(), "Smartwath", "To jest zegarek elektroniczny z powiadomieniami z telefonu", 605.0, 3l));
            add(new Product(nextIdx(), "Telewizor", "To jest Telewizor ma funkcję smart jakoś 4K", 6600.0, 4l));
            add(new Product(nextIdx(), "Kino Domowe", "To jest Kino domowe idealne do twojego salonu", 2600.0, 4l));
            add(new Product(nextIdx(), "Odtwarzacz Video", "To jest odtwarzacz Video ", 1800.0, 4l));
            add(new Product(nextIdx(), "Car Audio", "To jest Car Audio wysoka jakość Dźwieku", 605.0, 4l));
        }
    };

    @GetMapping
    public List<Product> getProducts() {
        return products;
    }

    @PostMapping
    public Integer addProduct(@RequestBody ProductDTO dto) {
        System.out.println(dto);
        Product newProduct = dto.toProduct(nextIdx());
        products.add(newProduct);

        return newProduct.id();
    }

    @GetMapping("/{id}")
    public Product getEditProduct(@PathVariable Integer id) {
        return getProducts().get(id.intValue() - 1);
    }


    @PutMapping("/{id}")
    public Product postEditProduct(@PathVariable Integer id, @RequestBody ProductDTO dto) {
        System.out.println(dto);
        Product product = dto.toProduct(id);
        products.set(id - 1, product);
        return product;
    }

    @DeleteMapping("/{id}")
    public Integer deleteEditProduct(@PathVariable Integer id) {
        products.remove(id-1);
        return id;
    }

    @GetMapping("/category/{categoryId}")
    public List<Product> products(@PathVariable Long categoryId) {
        log.debug("categoryid: {}", categoryId);
        System.out.println("category " + categoryId);
        return getProducts().stream()
                .filter(v -> v.categoryId().equals(categoryId))
                .collect(Collectors.toList());
    }

    private Integer nextIdx() {
        return index.incrementAndGet();
    }
}
