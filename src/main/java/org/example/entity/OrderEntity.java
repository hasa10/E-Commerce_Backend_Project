package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.example.enums.OrderStatus;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderDescription;

    private Date date;

    private Long amount;

    private String address;

    private String payment;

    private OrderStatus orderStatus;

    private Long totalAmount;

    private Long discount;

    private UUID trackingId;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity userEntity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderEntity")
    private List<CartItemsEntity> cartItems;
}
