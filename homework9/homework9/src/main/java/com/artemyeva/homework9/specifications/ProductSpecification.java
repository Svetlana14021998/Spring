package com.artemyeva.homework9.specifications;

import com.artemyeva.homework9.entities.Product;
import org.springframework.data.jpa.domain.Specification;


public class ProductSpecification {
    public static Specification<Product> costGreaterThanOrEqual(Integer minCost){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("cost"),minCost);
    }
    public static Specification<Product> costLessThanOrEqual(Integer maxCost){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("cost"),maxCost);
    }
    public static Specification<Product> titleLike(String part){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"),String.format("%%%s%%",part));
    }
}
