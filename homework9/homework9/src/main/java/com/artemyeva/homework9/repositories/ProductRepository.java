package com.artemyeva.homework9.repositories;

import com.artemyeva.homework9.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> , JpaSpecificationExecutor<Product> {
    List<Product> findAllByCostBetween(Integer min, Integer max);
}
