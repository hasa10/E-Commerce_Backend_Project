package org.example.service.customer;

import org.example.dto.Product;

import java.util.List;

public interface CustomerProductService {
    List<Product> getAllProducts();
    List<Product> searchProductByName(String name);
}