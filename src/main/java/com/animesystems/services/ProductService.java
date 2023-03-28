package com.animesystems.services;

import com.animesystems.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface ProductService {
    public void deleteProduct(Integer id);
    public Product createOrUpdateProduct(Integer id, Product product) throws Exception;
    public Page<Product> getAllProducts(int page, int size);
    public Product getProductById(Integer id);
    Page<Product> getContainsTitle(String title, int page, int size);
    Page<Product> getContainsDescription(String description, int page, int size);
    Page<Product> getBetweenPrice(BigDecimal minPrice, BigDecimal maxPrice, int page, int size);
    Page<Product> getByCategory(String category, int page, int size);
    Page<Product> getByColor(String color, int page, int size);
    Page<Product> getBySize(String productSize, int page, int size);
}
