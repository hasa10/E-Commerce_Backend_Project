package org.example.service.cart;

import jakarta.persistence.criteria.Order;
import lombok.RequiredArgsConstructor;
import org.example.dto.AddProductInCart;
import org.example.entity.CartItemsEntity;
import org.example.entity.OrderEntity;
import org.example.entity.ProductEntity;
import org.example.entity.UserEntity;
import org.example.enums.OrderStatus;
import org.example.repository.CartItemDao;
import org.example.repository.OrderDao;
import org.example.repository.ProductDao;
import org.example.repository.UserDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{

    private final OrderDao orderDao;

    private final UserDao userDao;

    private final CartItemDao cartItemDao;

    private final ProductDao productDao;

    public ResponseEntity<?> addProductToCart(AddProductInCart addProductInCart) {
        OrderEntity activeOrder = orderDao.findByUserIdAndStatus(addProductInCart.getUserId(), OrderStatus.Pending);
        Optional<CartItemsEntity> optionalCartItems = cartItemDao.findByProductIdAndOrderIdAndUserId(
                addProductInCart.getProductId(), activeOrder.getId(), addProductInCart.getUserId());

        if (optionalCartItems.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        } else {
            Optional<ProductEntity> optionalProduct = productDao.findById(addProductInCart.getProductId());
            Optional<UserEntity> optionalUser = userDao.findById(addProductInCart.getUserId());

            if (optionalProduct.isPresent() && optionalUser.isPresent()) {
                CartItemsEntity cart = new CartItemsEntity();
                cart.setProduct(optionalProduct.get());
                cart.setPrice(optionalProduct.get().getPrice());
                cart.setQuantity(1L);
                cart.setUser(optionalUser.get());
                cart.setOrder(activeOrder);

                CartItemsEntity updatedCartItems = cartItemDao.save(cart);

                activeOrder.setTotalAmount(activeOrder.getTotalAmount()+ cart.getPrice());
                activeOrder.setAmount(activeOrder.getAmount()+ cart.getPrice());
                activeOrder.getCartItems().add(cart);

                orderDao.save(activeOrder);

                return ResponseEntity.status(HttpStatus.CREATED).body(cart);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User or product not found");
            }
        }
    }
}
