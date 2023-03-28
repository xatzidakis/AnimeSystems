package com.animesystems.repositories;

import com.animesystems.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> findByTitleContainingIgnoreCase(String inTitle, Pageable pageable);
    Page<Product> findByDescriptionContainingIgnoreCase(String inDescription, Pageable pageable);
    Page<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice, Pageable pageable);
    Page<Product> findByCategoryEquals(String category, Pageable pageable);
    Page<Product> findByColorEquals(String color, Pageable pageable);
    Page<Product> findBySizeEquals(String productSize, Pageable pageable);
}
