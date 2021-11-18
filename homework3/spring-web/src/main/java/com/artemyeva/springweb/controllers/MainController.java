package com.artemyeva.springweb.controllers;

import com.artemyeva.springweb.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    ProductRepository productRepository;

    public MainController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //http:localhost:8189/hw3/


    @GetMapping("/products")
    public String showAll(Model model) {

        model.addAttribute("products", productRepository.getAllProduct());
        return "all_products";


    }
}
