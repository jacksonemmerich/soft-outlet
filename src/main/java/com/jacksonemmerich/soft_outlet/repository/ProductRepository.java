package com.jacksonemmerich.soft_outlet.repository;

import com.jacksonemmerich.soft_outlet.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(String category);

    List<Product> findByBrand(String brand);

    List<Product> findyByName(String name);

    List<Product> findByProductPriceBetween(BigDecimal start, BigDecimal end);

    List<Product> findByBrandAndName(String name, String brand);

    List<Product> findByCategoryAndName(String name, String category);

    List<Product> findByCategoryNameAndBrand(String category, String brand);

    Long countByBrandAndName(String brand, String name);
}