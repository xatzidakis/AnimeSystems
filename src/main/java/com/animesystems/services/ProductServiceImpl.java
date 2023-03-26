package com.animesystems.services;

import com.animesystems.entities.Product;
import com.animesystems.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void deleteProduct(Integer id) {
        Product productToDelete = productRepository.findById(id).orElseThrow();
        productRepository.delete(productToDelete);
    }

    public Product createOrUpdateProduct(Integer id, Product product) throws Exception {
        if(id !=null) {
            if(!id.equals(product.getId())) {
                throw new Exception("id provided does not match id in body");
            }
        }
        return productRepository.save(product);
    }

    public Page<Product> getAllProducts(int page, int size) {
        PageRequest paging = PageRequest.of(page, size);
        return productRepository.findAll(paging);
    }
}
