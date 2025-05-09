package org.example.controller.admin;


import lombok.RequiredArgsConstructor;
import org.example.dto.Category;
import org.example.entity.CategoryEntity;
import org.example.service.admin.category.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminCategoryController {

    private final CategoryService categoryService;

    @PostMapping("category")
    public ResponseEntity<CategoryEntity> createCategory(@RequestBody Category category){
        CategoryEntity categoryEntity = categoryService.createCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryEntity);
    }
}
