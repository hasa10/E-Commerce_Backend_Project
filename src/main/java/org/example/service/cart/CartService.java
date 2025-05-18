package org.example.service.cart;

import org.example.dto.AddProductInCart;
import org.springframework.http.ResponseEntity;

public interface CartService {

    ResponseEntity<?> addProductToCart(AddProductInCart addProductInCart);
}
