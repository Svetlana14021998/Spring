package com.artemyeva.homework9.controllers;

import com.artemyeva.homework9.dto.ProductDto;
import com.artemyeva.homework9.entities.Product;
import com.artemyeva.homework9.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Page<ProductDto> loadProduct(
            @RequestParam(name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "min_cost", required = false) Integer minCost,
            @RequestParam(name = "max_cost", required = false) Integer maxCost,
            @RequestParam(name = "title_part", required = false) String part
    ) {
        if (page < 1) {
            page = 1;
        }
        return productService.find(minCost, maxCost, part, page).map(product -> new ProductDto(product));

    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        return  new ProductDto(productService.findById(id).orElseThrow(() -> new RuntimeException()));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @PostMapping
    public ProductDto saveNewProduct(@RequestBody ProductDto productDto) {
        Product product = new Product();
        product.setId(null);
        product.setTitle(productDto.getTitle());
        product.setCost(productDto.getCost());
        return new ProductDto(productService.save(product));
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        Optional<Product> product = productService.findById(productDto.getId());
        product.get().setCost(productDto.getCost());
        product.get().setTitle(productDto.getTitle());
        return new ProductDto(productService.save(product.get()));
    }


}
//post&put+dto
