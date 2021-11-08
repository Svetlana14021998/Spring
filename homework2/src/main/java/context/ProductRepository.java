package context;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {
    List<Product> products;


    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Bread", 20),
                new Product(2L, "Milk", 30),
                new Product(3L, "Apples", 40),
                new Product(4L, "Cheeps", 60),
                new Product(5L, "Chocolate", 70)
        ));
    }

    public Product findById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);

    }

    public void showAll() {
        for (Product p : products) {
            System.out.println(p.toString());
        }
    }


}
