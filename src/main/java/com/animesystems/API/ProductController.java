package com.animesystems.API;

import com.animesystems.entities.Product;
import com.animesystems.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @CrossOrigin
    @GetMapping
    public Page<Product> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        return productService.getAllProducts(page, size);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getProductById(@PathVariable Integer id) {
        Product product = productService.getProductById(id);
        if(product == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(product);
        }
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
    @PostMapping("/many")
    public List<Product> addManyProducts(@RequestBody List<Product> products) {
        try {
            return productService.addManyProducts(products);
        } catch (Exception e) {
            throw  new HttpClientErrorException(HttpStatusCode.valueOf(400), e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Product addProduct(@PathVariable Integer id, @RequestBody Product product) {
        try {
            return productService.createOrUpdateProduct(id, product);
        } catch (Exception e) {
            throw  new HttpClientErrorException(HttpStatusCode.valueOf(400), e.getMessage());
        }
    }
}
