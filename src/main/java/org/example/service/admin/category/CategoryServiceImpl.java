package org.example.service.admin.category;

import lombok.RequiredArgsConstructor;
import org.example.dto.Category;
import org.example.entity.CategoryEntity;
import org.example.repository.CategoryDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao;

    public CategoryEntity createCategory(Category category) {
        CategoryEntity categoryEntity = new CategoryEntity(null, category.getName(), category.getDescription());
        return categoryDao.save(categoryEntity);
    }

    public List<CategoryEntity> getAllCategories() {
        return categoryDao.findAll();
    }
}
