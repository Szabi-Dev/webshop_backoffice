package com.szabidev.webshop_backend.facade;

import com.szabidev.webshop_backend.controller.dto.CategoryJson;
import com.szabidev.webshop_backend.facade.dto.CategoryData;
import com.szabidev.webshop_backend.facade.dto.PrivilegeData;
import org.springframework.hateoas.CollectionModel;

import java.util.Optional;

/**
 * Facade to transform results for frontend
 */
public interface CategoryFacade {

    Optional<CategoryData> getCategoryById(Long id);

    Optional<CategoryData> createCategory(CategoryJson categoryJson);

    CollectionModel<CategoryData> fetchAllCategories();
}
