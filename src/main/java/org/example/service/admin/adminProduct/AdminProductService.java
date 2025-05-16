package org.example.service.admin.adminProduct;

import org.example.dto.Product;

import java.io.IOException;
import java.util.List;

public interface AdminProductService {

    Product addProduct(Product product) throws IOException;

    List<Product> getAllProducts();
}
