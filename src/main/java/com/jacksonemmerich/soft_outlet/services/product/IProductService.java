package com.jacksonemmerich.soft_outlet.services.product;

import com.jacksonemmerich.soft_outlet.dto.ProductDto;
import com.jacksonemmerich.soft_outlet.model.Product;
import com.jacksonemmerich.soft_outlet.request.AddProductRequest;
import com.jacksonemmerich.soft_outlet.request.ProductUpdateRequest;

import java.util.List;

public interface IProductService {
    Product addProduct(AddProductRequest product);

    Product getProductById(Long id);

    void deleteProductById(Long id);

    Product updateProduct(ProductUpdateRequest product, Long productId);

    List<Product> getAllProducts();

    List<Product> getProductsByCategory(String category);

    List<Product> getProductsByBrand(String brand);

    List<Product> getProductsByCategoryAndBrand(String category, String brand);

    List<Product> getProductsByName(String name);

    List<Product> getProductsByBrandAndName(String category, String name);

    Long countProductsByBrandAndName(String brand, String name);

    List<ProductDto> getConvertedProducts(List<Product> products);

    ProductDto convertToDto(Product product);

}
