package org.example.service.admin.category;

import lombok.RequiredArgsConstructor;
import org.example.repository.CategoryDao;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl {

    private final CategoryDao categoryDao;
}
