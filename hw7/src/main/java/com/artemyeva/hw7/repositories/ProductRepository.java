package com.artemyeva.hw7.repositories;

import com.artemyeva.hw7.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> getAllProducts();
}
