package com.animesystems.services;
import com.animesystems.entities.Product;
import com.animesystems.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

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
        Product finalProduct;
        if(id !=null) {
            Optional<Product> existingProduct = productRepository.findById(id);
            if(existingProduct.isPresent()) {
                product.setId(id);
            }
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

    public Product getProductById(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    public Page<Product> getContainsTitle(String title, int page, int size) {
        PageRequest paging = PageRequest.of(page, size);
        return productRepository.findByTitleContainingIgnoreCase(title, paging);
    }

    public Page<Product> getContainsDescription(String description, int page, int size) {
        PageRequest paging = PageRequest.of(page, size);
        return productRepository.findByDescriptionContainingIgnoreCase(description, paging);
    }

    public Page<Product> getBetweenPrice(BigDecimal minPrice, BigDecimal maxPrice, int page, int size) {
        PageRequest paging = PageRequest.of(page, size);
        return productRepository.findByPriceBetween(minPrice, maxPrice, paging);
    }

    public Page<Product> getByCategory(String category, int page, int size) {
        PageRequest paging = PageRequest.of(page, size);
        return productRepository.findByCategoryEquals(category, paging);
    }

    public Page<Product> getByColor(String color, int page, int size) {
        PageRequest paging = PageRequest.of(page, size);
        return productRepository.findByColorEquals(color, paging);
    }

    public Page<Product> getBySize(String productSize, int page, int size) {
        PageRequest paging = PageRequest.of(page, size);
        return productRepository.findBySizeEquals(productSize, paging);
    }
    @Override
    public List<Product> addManyProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }
}
