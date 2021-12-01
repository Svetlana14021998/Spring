package com.artemyeva.homework4.controllers;

import com.artemyeva.homework4.data.Product;

import com.artemyeva.homework4.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //show
    @GetMapping("/products")
    public List<Product> showProducts() {
        return productService.showProducts();
    }

    //delete (не забывать про /{id})
    @GetMapping("/product/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

}
