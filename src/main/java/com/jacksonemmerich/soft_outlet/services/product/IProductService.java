package com.jacksonemmerich.soft_outlet.services.product;

import com.jacksonemmerich.soft_outlet.model.Product;
import com.jacksonemmerich.soft_outlet.request.AddProductRequest;
import com.jacksonemmerich.soft_outlet.request.ProductUpdateRequest;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

public interface IProductService {
    Product addProduct(AddProductRequest product);
    Product getProductById(Long id);
    void deleteProductById(Long id);
    Product updateProduct(ProductUpdateRequest product, Long productId);
    List<Product> getAllProducts();


    List<Product> getAllProductsPageable(Pageable pageable);

    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByBrand(String brand);
    List<Product> getProductsByCategoryAndBrand(String category, String brand);
    List<Product> getProductsByName(String name);
    List<Product> getProductsByPriceRange(BigDecimal start, BigDecimal end);
    List<Product> getProductsByBrandAndName(String name, String brand);
    List<Product> getProductsByCategoryAndName(String name, String category);
    Long countProductsByBrandAndName(String name, String brand);


   /* List<Product> getProductsByPriceRangeAndBrand(String brand, BigDecimal start, BigDecimal end);
    List<Product> getProductsByPriceRangeAndCategory(String category, BigDecimal start, BigDecimal end);
    List<Product> getProductsByPriceRangeAndBrandAndCategory(String category, String brand, BigDecimal start, BigDecimal end);
    List<Product> getProductsByPriceRangeAndName(String name, BigDecimal start, BigDecimal end);
    List<Product> getProductsByPriceRangeAndBrandAndName(String name, String brand, BigDecimal start, BigDecimal end);
    List<Product> getProductsByPriceRangeAndCategoryAndName(String name, String category, BigDecimal start, BigDecimal end);
    List<Product> getProductsByPriceRangeAndBrandAndCategoryAndName(String name, String category, String brand, BigDecimal start, BigDecimal end);*/


}
