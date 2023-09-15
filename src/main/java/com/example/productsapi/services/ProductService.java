package com.example.productsapi.services;

import com.example.productsapi.dto.ProductDto;
import com.example.productsapi.entities.Product;
import com.example.productsapi.repositories.IProductRepository;
import jakarta.persistence.PersistenceException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    private IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    private Product getProduct(ProductDto productDto) {
        return new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getDescription(),
                productDto.getStock(),
                productDto.getBase_price(),
                productDto.getCost_price()
        );
    }

    private ProductDto getProductDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getStock(),
                product.getBase_price(),
                product.getCost_price()
        );
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> productsList = productRepository.findAll();

        if(productsList.isEmpty())
            return Collections.emptyList();

        return productsList.stream().map(
                this::getProductDto
        ).toList();
    }

    @Override
    public Optional<ProductDto> getProductById(Long id) {

        Optional<Product> productOptional = productRepository.findById(id);

        if(productOptional.isEmpty())
            return Optional.ofNullable(null);

        ProductDto productDto = this.getProductDto(productOptional.get());

        return Optional.of(productDto);
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {

        Product product = this.getProduct(productDto);

        try {
            return this.getProductDto(productRepository.save(product));
        } catch (DataIntegrityViolationException | JpaSystemException | PersistenceException e) {
            e.printStackTrace();
        }

        return null;
    }
}
