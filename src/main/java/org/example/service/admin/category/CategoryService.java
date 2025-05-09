package org.example.service.admin.category;

import org.example.dto.Category;
import org.example.entity.CategoryEntity;

public interface CategoryService {

    CategoryEntity createCategory(Category category);
}
