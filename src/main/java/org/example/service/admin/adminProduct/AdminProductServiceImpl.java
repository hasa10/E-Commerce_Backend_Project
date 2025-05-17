package org.example.service.admin.adminProduct;

import lombok.RequiredArgsConstructor;
import org.example.dto.Product;
import org.example.entity.CategoryEntity;
import org.example.entity.ProductEntity;
import org.example.repository.CategoryDao;
import org.example.repository.ProductDao;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Product> getAllProducts() {
        List<ProductEntity> all = productDao.findAll();
        return all.stream().map(ProductEntity::getDto).collect(Collectors.toList());
    }

    public List<Product> getAllProductByName(String name) {
        List<ProductEntity> all = productDao.findAllByNameContaining(name);
        return all.stream().map(ProductEntity::getDto).collect(Collectors.toList());
    }

}