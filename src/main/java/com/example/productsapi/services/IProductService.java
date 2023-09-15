package com.example.productsapi.services;

import com.example.productsapi.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    List<ProductDto> getAllProducts();
    Optional<ProductDto> getProductById(Long id);
    ProductDto createProduct(ProductDto productDto);
}
