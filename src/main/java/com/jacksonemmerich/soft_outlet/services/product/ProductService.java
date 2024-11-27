package com.jacksonemmerich.soft_outlet.services.product;

import com.jacksonemmerich.soft_outlet.exceptions.ProductNotFoundException;
import com.jacksonemmerich.soft_outlet.model.Product;
import com.jacksonemmerich.soft_outlet.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }

    @Override
    public void deleteProductById(Long id) {

    }

    @Override
    public void updateProduct(Product product, Long productId) {

    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return List.of();
    }

    @Override
    public List<Product> getProductsByBrand(String brand) {
        return List.of();
    }

    @Override
    public List<Product> getProductsByCategoryAndBrand(String category, String brand) {
        return List.of();
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return List.of();
    }

    @Override
    public List<Product> getProductsByPriceRange(BigDecimal start, BigDecimal end) {
        return List.of();
    }

    @Override
    public List<Product> getProductsByBrandAndName(String name, String brand) {
        return List.of();
    }

    @Override
    public List<Product> getProductsByCategoryAndName(String name, String category) {
        return List.of();
    }

    @Override
    public Long countProductsByBrandAndName(String name, String brand) {
        return 0L;
    }
}
