package org.example.repository;

import org.example.entity.OrderEntity;
import org.example.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends JpaRepository<OrderEntity, Long> {
    OrderEntity findByUserIdAndStatus(Long userId, OrderStatus orderStatus);

}
