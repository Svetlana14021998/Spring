package context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Scope("prototype")


public class Cart {
    @Autowired
    ProductRepository productRepository;
    List<Product> productsInCart;

    public void show() {
        System.out.println("In cart: ");
        for (Product p : productsInCart) {
            System.out.println(p.toString());
        }

    }

    @PostConstruct
    public void init() {
        productsInCart = new ArrayList<>(Arrays.asList());
    }

    public void add(Long id) {
        Product p = productRepository.findById(id);
        if (p == null) {
            System.out.println("Product not found");
        } else
            productsInCart.add(p);
    }

    public void remove(Long id) {
        Product p = productRepository.findById(id);
        if (p == null) {
            System.out.println("Product not found");
        } else
            productsInCart.remove(p);
    }
}
