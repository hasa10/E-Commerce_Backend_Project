package org.example.service.admin.category;

import org.example.dto.Category;
import org.example.entity.CategoryEntity;

import java.util.List;

public interface CategoryService {

    CategoryEntity createCategory(Category category);

    List<CategoryEntity> getAllCategories();
}
