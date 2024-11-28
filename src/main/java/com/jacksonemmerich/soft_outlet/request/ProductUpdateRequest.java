package com.jacksonemmerich.soft_outlet.request;

import com.jacksonemmerich.soft_outlet.model.Category;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductUpdateRequest {
    private Long id;
    private String name;
    private String Brand;
    private BigDecimal price;
    private int inventory;
    private String description;
    private Category category;

}
