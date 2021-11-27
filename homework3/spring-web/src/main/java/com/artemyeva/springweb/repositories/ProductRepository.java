package com.artemyeva.springweb.repositories;

import com.artemyeva.springweb.data.Product;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    List<Product> products;
    @PostConstruct
    public void init(){
        products = new ArrayList<>(List.of(
                new Product(1L,"Milk",100),
                new Product(2L,"Bread",200),
                new Product(3L, "Strawberry",300),
                new Product(4L,"Chocolate",400)
        ));
    }
    public List<Product> getAllProduct(){
        return Collections.unmodifiableList(products);
    }
    public Product getProductById(@PathVariable Long id){
        return products.stream().filter(s ->s.getId().equals(id)).findFirst().orElseThrow(()->new  RuntimeException("this product is not found"));
    }
}

