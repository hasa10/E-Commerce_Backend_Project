package org.example.repository;

import org.example.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<ProductEntity,Long> {
    List<ProductEntity> findAllByNameContaining(String title);
}
