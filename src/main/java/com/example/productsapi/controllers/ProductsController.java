package com.example.productsapi.controllers;

import com.example.productsapi.dto.ProductDto;
import com.example.productsapi.services.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private IProductService productService;

    public ProductsController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("getAll")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> productsDtoList = productService.getAllProducts();

        if(productsDtoList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(productsDtoList, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        Optional<ProductDto> productDtoOptional = productService.getProductById(id);

        return productDtoOptional.map(productDto -> new ResponseEntity<>(productDto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        try {
            ProductDto productDtoToSave = productService.createProduct(productDto);
            return new ResponseEntity<>(productDtoToSave, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PostMapping("/update")
//    public ResponseEntity<SuccesfullResponse> updateProduct(@RequestBody ProductDto productDto) {
//        return new ResponseEntity<>(productService.createProduct(productDto), HttpStatus.OK);
//    }

//    @DeleteMapping("/delete")
//    public ResponseEntity<SuccesfullResponse> deleteProduct(@RequestBody ProductDto productDto) {
//        return new ResponseEntity<>(productService.createProduct(productDto), HttpStatus.OK);
//    }
}
