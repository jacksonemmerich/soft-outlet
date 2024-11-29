package com.jacksonemmerich.soft_outlet.repository;

import com.jacksonemmerich.soft_outlet.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}