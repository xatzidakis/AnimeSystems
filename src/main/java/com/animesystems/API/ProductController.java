package com.animesystems.API;

import com.animesystems.entities.Product;
import com.animesystems.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Page<Product> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        return productService.getAllProducts(page, size);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        try {
            return productService.createOrUpdateProduct(product.getId(), product);
        } catch (Exception e) {
            throw  new HttpClientErrorException(HttpStatusCode.valueOf(400), e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Product addProduct(@PathVariable Integer id, @RequestBody Product product) {
        try {
            return productService.createOrUpdateProduct(product.getId(), product);
        } catch (Exception e) {
            throw  new HttpClientErrorException(HttpStatusCode.valueOf(400), e.getMessage());
        }
    }
}