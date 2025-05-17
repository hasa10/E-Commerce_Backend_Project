package org.example.controller.admin;

import lombok.RequiredArgsConstructor;
import org.example.dto.Product;
import org.example.service.admin.adminProduct.AdminProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminProductController {

    private final AdminProductService adminProductService;

    @PostMapping("/product")
    public ResponseEntity<Product> addProduct(@ModelAttribute Product product) throws IOException {
        Product productAdd = adminProductService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productAdd);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = adminProductService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<Product>> getAllProductByName(@PathVariable String name) {
        List<Product> products = adminProductService.getAllProductByName(name);
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        boolean deleted = adminProductService.deleteProduct(productId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}