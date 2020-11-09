package com.szabidev.webshop_backend.facade;

import com.szabidev.webshop_backend.controller.dto.CategoryJson;
import com.szabidev.webshop_backend.facade.dto.CategoryData;
import com.szabidev.webshop_backend.facade.dto.ProductData;
import org.springframework.hateoas.CollectionModel;

import java.util.Optional;

/**
 * Facade to transform results for frontend
 */
public interface CategoryFacade {
    /**
     * Method to fetch category by Id
     * @param id - category id
     * @return {@link Optional<CategoryData>}
     */
    Optional<CategoryData> getCategoryById(Long id);

    /**
     * Method to create a category
     * @param categoryJson - {@link CategoryJson}
     * @return @link Optional<CategoryData>}
     */
    Optional<CategoryData> createCategory(CategoryJson categoryJson);

    /**
     * Method to patch category
     * @param categoryJson - {@link CategoryJson}
     * @param id - category id
     * @return {@link Optional<CategoryData>}
     */
    Optional<CategoryData> patchCategory(CategoryJson categoryJson, Long id);

    /**
     * Method to delete category
     * @param id - category id
     * @return {@link Optional<CategoryData>}
     */
    Optional<CategoryData> deleteCategory(Long id);

    /**
     * method to fetch all categories
     * @return {@link CollectionModel<CategoryData>}
     */
    CollectionModel<CategoryData> fetchAllCategories();

    /**
     * Method to fetch all categories for product
     * @param id - category id
     * @return {@link CollectionModel<ProductData>}
     */
    CollectionModel<ProductData> findAllProductsForCategories(Long id);
}
