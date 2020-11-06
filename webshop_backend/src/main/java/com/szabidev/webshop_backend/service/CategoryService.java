package com.szabidev.webshop_backend.service;

import com.szabidev.webshop_backend.model.CategoryModel;

import java.util.List;
import java.util.Optional;

/**
 * Service to provide category specific operation
 */
public interface CategoryService {
    /**
     * Method to find all categories
     *
     * @return
     */
    List<CategoryModel> findAllCategories();

    /**
     * Method to get Category by Id
     * @param id - category id
     * @return {@link CategoryModel}
     */
    Optional<CategoryModel> getCategoryById(Long id);

    /**
     * Method to create a new Category
     * @param categoryModel - {@link CategoryModel}
     * @return {@link Optional<CategoryModel>}
     */
    Optional<CategoryModel> createCategory(CategoryModel categoryModel);

    /**
     * Method to update category
     * @param categoryModel - {@link CategoryModel}
     * @param id - category id
     * @return {@link Optional<CategoryModel>}
     */
    Optional<CategoryModel> updateCategory(CategoryModel categoryModel, Long id);

    /**
     * Method to patch category (update just fields that are present)
     * @param categoryModel - {@link CategoryModel}
     * @param id - category id
     * @return
     */
    Optional<CategoryModel> patchCategory(CategoryModel categoryModel, Long id);

    /**
     * Method to delete category
     * @param id - category id
     * @return {@link Optional<CategoryModel>}
     */
    Optional<CategoryModel>  deleteCategory(Long id);
}
