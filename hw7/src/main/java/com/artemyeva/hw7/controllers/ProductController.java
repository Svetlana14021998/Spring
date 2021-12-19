package com.artemyeva.hw7.controllers;

import com.artemyeva.hw7.entities.Product;
import com.artemyeva.hw7.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.findById(id).orElseThrow(() ->new RuntimeException());
    }

    @GetMapping("/products/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

}
//получение товара по id [ GET .../app/products/{id} ]
//получение всех товаров [ GET .../app/products ]
//создание нового товара [ POST .../app/products ] (необязательный пункт)
//удаление товара по id.[ GET .../app/products/delete/{id} ]
//@GetMapping("/students/{id}")
//    public Student getStudentById(@PathVariable Long id) {
//        return studentService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found, id: " + id));
//    }