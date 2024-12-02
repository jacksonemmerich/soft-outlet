package com.jacksonemmerich.soft_outlet.repository;

import com.jacksonemmerich.soft_outlet.model.Category;
import com.jacksonemmerich.soft_outlet.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Category category);

    List<Product> findByBrand(String brand);

    List<Product> findByName(String name);

    List<Product> findByBrandAndName(String name, String brand);

    List<Product> findByCategoryAndName(Category category, String name);

    List<Product> findByCategoryNameAndBrand(String category, String brand);

    Long countByBrandAndName(String brand, String name);
}