package com.example.productsapi.utils;

import com.example.productsapi.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductsUtils {

    public static List<Product> getProductsList() {
        List<Product> productsList = new ArrayList<>();

        productsList.add(new Product(1L, "caramelo", "caramelo", 10L, 100.0, 100.0));
        productsList.add(new Product(2L, "chicle", "caramelo", 20L, 100.0, 100.0));
        productsList.add(new Product(3L, "chupetin", "caramelo", 30L, 100.0, 100.0));
        productsList.add(new Product(4L, "chocolate", "caramelo", 40L, 100.0, 100.0));
        productsList.add(new Product(5L, "turron", "caramelo", 50L, 100.0, 100.0));

        return productsList;
    }
}
