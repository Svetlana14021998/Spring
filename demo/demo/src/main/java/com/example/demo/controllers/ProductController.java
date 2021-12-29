package com.example.demo.controllers;


import com.example.demo.entities.Product;
import com.example.demo.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products")
    public List<Product> loadProduct(@RequestParam(defaultValue = "0") Integer minFilter, @RequestParam(required = false) Integer maxFilter) {
        if (maxFilter == null) {
            maxFilter = Integer.MAX_VALUE;
        }
        return productService.findAllByCostBetween(minFilter, maxFilter);

    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.findById(id).orElseThrow(() -> new RuntimeException());
    }

    @GetMapping("/product/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

}


