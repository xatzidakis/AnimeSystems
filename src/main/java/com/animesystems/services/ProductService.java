package com.animesystems.services;

import com.animesystems.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    public void deleteProduct(Integer id);
    public Product createOrUpdateProduct(Integer id, Product product) throws Exception;
    public Page<Product> getAllProducts(int page, int size);
}
