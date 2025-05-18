package org.example.repository;

import org.example.entity.CartItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartItemDao extends JpaRepository<CartItemsEntity, Long> {

    Optional<CartItemsEntity> findByProductIdAndOrderIdAndUserId(Long productId, Long orderId, Long userId);

}
