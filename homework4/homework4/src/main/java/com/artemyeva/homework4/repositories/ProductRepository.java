package com.artemyeva.homework4.repositories;

import com.artemyeva.homework4.data.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    List<Product> products;

    public ProductRepository() {
    }

    @PostConstruct
    public void init() {
        products = new ArrayList<>(List.of(
                new Product(1L, "Milk", 10),
                new Product(2L, "Apple", 20),
                new Product(3L, "Orange", 30),
                new Product(4L, "Bread", 40),
                new Product(5l, "Tea", 50)
        ));
    }

    public void deleteById(Long id) {
        products.removeIf(s -> s.getId().equals(id));
    }

    public Product findById(Long id) {
        return products.stream().filter(s -> s.getId().equals(id)).findFirst().get();
    }

    public List<Product> getAllProduct() {
        return Collections.unmodifiableList(products);
    }
}
