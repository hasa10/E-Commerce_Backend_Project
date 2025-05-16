package org.example.service.admin.adminProduct;

import lombok.RequiredArgsConstructor;
import org.example.dto.Product;
import org.example.entity.CategoryEntity;
import org.example.entity.ProductEntity;
import org.example.repository.CategoryDao;
import org.example.repository.ProductDao;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AdminProductServiceImpl implements AdminProductService {

    private final ProductDao productDao;

    private final CategoryDao categoryDao;

    public Product addProduct(Product product) throws IOException {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(product.getName());
        productEntity.setDescription(product.getDescription());
        productEntity.setPrice(product.getPrice());
        productEntity.setImg(product.getImg().getBytes());

        CategoryEntity categoryEntity = categoryDao.findById(product.getCategoryId()).orElseThrow();

        productEntity.setCategoryEntity(categoryEntity);
        return productDao.save(productEntity).getDto();
    }

}