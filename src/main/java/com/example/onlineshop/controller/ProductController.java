package com.example.onlineshop.controller;
import com.example.onlineshop.dto.CategoryDTO;
import com.example.onlineshop.model.Product;
import com.example.onlineshop.dto.ProductDTO;
import com.example.onlineshop.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public ResponseEntity addProduct(@RequestBody ProductDTO dto, CategoryDTO categoryDTO) {
        productService.addOneProduct(dto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Product getEditProduct(@PathVariable Long id) {
        return productService.getProductById(id);
    }


    @PutMapping("/{id}")
    public Product postEditProduct(@PathVariable Long id, @RequestBody ProductDTO dto) {
        return productService.editOneProduct(id, dto);
    }

    @DeleteMapping("/{id}")
    public Long deleteEditProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);

    }

    @GetMapping("/category/{categoryId}")
    public List<Product> products(@PathVariable Long categoryId) {
        return productService.getListProductByCategoryId(categoryId);
    }


}
