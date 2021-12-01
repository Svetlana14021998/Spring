package com.artemyeva.homework4.services;

import com.artemyeva.homework4.data.Product;
import com.artemyeva.homework4.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> showProducts() {
        return productRepository.getAllProduct();
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
