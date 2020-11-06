package com.szabidev.webshop_backend.service;

import com.szabidev.webshop_backend.model.CategoryModel;

import java.util.List;
import java.util.Optional;

/**
 * Service to provide category specific operation
 */
public interface CategoryService {

    List<CategoryModel> findAllCategories();

    Optional<CategoryModel> getCategoryById(Long id);

    Optional<CategoryModel> createCategory(CategoryModel categoryModel);

    Optional<CategoryModel> updateCategory(CategoryModel categoryModel, Long id);

    Optional<CategoryModel> patchCategory(CategoryModel categoryModel, Long id);

    Optional<CategoryModel>  deleteCategory(Long id);
}
