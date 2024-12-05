package com.jacksonemmerich.soft_outlet.repository;

import com.jacksonemmerich.soft_outlet.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findByProductId(Long id);
}