package com.jacksonemmerich.soft_outlet.repository;

import com.jacksonemmerich.soft_outlet.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}