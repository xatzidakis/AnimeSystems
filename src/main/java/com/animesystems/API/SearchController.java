package com.animesystems.API;
import com.animesystems.entities.Product;
import com.animesystems.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/search")
public class SearchController {
    private final ProductService productService;

    public SearchController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/title")
    public Page<Product> findContainingTitle(@RequestParam String title, @RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "3") int size) {
        return productService.getContainsTitle(title, page, size);
    }

    @GetMapping("/product/description")
    public Page<Product> findContainingDescription(@RequestParam String description, @RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "3") int size) {
        return productService.getContainsDescription(description, page, size);
    }

    @GetMapping("/product/price")
    public Page<Product> findBetweenPrice(@RequestParam BigDecimal minPrice, @RequestParam BigDecimal maxPrice, @RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "3") int size) {
        return productService.getBetweenPrice(minPrice, maxPrice, page, size);
    }

    @GetMapping("/product/category")
    public Page<Product> findCategory(@RequestParam String category, @RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "3") int size) {
        return productService.getByCategory(category, page, size);
    }

    @GetMapping("/product/color")
    public Page<Product> findColor(@RequestParam String color, @RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "3") int size) {
        return productService.getByColor(color, page, size);
    }

    @GetMapping("/product/productSize")
    public Page<Product> findSize(@RequestParam String productSize, @RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "3") int size) {
        return productService.getBySize(productSize, page, size);
    }
}
