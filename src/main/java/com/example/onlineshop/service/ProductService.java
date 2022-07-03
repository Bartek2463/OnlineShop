package com.example.onlineshop.service;

import com.example.onlineshop.dto.CategoryDTO;
import com.example.onlineshop.dto.ProductDTO;
import com.example.onlineshop.model.Category;
import com.example.onlineshop.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductService {
    private CategoryService categoryService;

    private AtomicLong index = new AtomicLong(0);
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

    private Long nextIdx() {
        return index.incrementAndGet();
    }

    public List<Product> getAllProducts() {
        return products;
    }
     public Boolean veryfyIfCategoryIdExists(List<Category> categories,Long id){
        if(categories.contains(id)){
            return true;
        }else {
            return false;
        }
     }

    public Long addOneProduct(ProductDTO dto) {
       if(veryfyIfCategoryIdExists(categoryService.categories,dto.getId())) {
           Product newProduct = dto.toProduct(nextIdx());
           products.add(newProduct);
           return newProduct.id();
       }else {
           throw  new IllegalArgumentException("The category does not exist");
       }

    }

    public Product getProductById(Long id) {
        return getAllProducts().get(id.intValue() - 1);
    }

    public Product editOneProduct(Long id, ProductDTO dto) {
        if(veryfyIfCategoryIdExists(categoryService.categories,dto.getId())) {

            Product product = dto.toProduct(id);
            products.set(id.intValue() - 1, product);
            return product;
        }else {
          throw new IllegalArgumentException("The category does not exist");
        }
    }
    public Long deleteProduct(Long id) {
        products.remove(id - 1);
        return id;
    }


    public List<Product> getListProductByCategoryId(Long categoryId) {
        log.debug("categoryid: {}", categoryId);
        System.out.println("category " + categoryId);
        return products.stream()
                .filter(v -> v.categoryId().equals(categoryId))
                .collect(Collectors.toList());
    }
}
