package com.artemyeva.homework9.services;

import com.artemyeva.homework9.entities.Product;
import com.artemyeva.homework9.repositories.ProductRepository;
import com.artemyeva.homework9.specifications.ProductSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> find(Integer minCost, Integer maxCost, String part, Integer page) {
        Specification<Product> specification = Specification.where(null);
        if (maxCost != null) {
            specification = specification.and(ProductSpecification.costLessThanOrEqual(maxCost));
        }
        if (minCost != null) {
            specification = specification.and(ProductSpecification.costGreaterThanOrEqual(minCost));
        }
        if (part != null) {
            specification = specification.and(ProductSpecification.titleLike(part));
        }
        return productRepository.findAll(specification, PageRequest.of(page - 1, 10));
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> findAllByCostBetween(Integer min, Integer max) {
        return productRepository.findAllByCostBetween(min, max);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }
}