package com.szabidev.webshop_backend.facade.impl;

import com.szabidev.webshop_backend.controller.dto.CategoryJson;
import com.szabidev.webshop_backend.facade.CategoryFacade;
import com.szabidev.webshop_backend.facade.assembler.CategoryDataAssembler;
import com.szabidev.webshop_backend.facade.converter.CategoryJsonConverter;
import com.szabidev.webshop_backend.facade.dto.CategoryData;
import com.szabidev.webshop_backend.model.CategoryModel;
import com.szabidev.webshop_backend.service.CategoryService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * Default implementation of {@link CategoryFacade}
 */
@Component("categoryFacade")
public class DefaultCategoryFacade implements CategoryFacade {

    @Resource(name = "categoryService")
    private CategoryService categoryService;

    @Resource(name = "categoryDataAssembler")
    private CategoryDataAssembler assembler;

    @Resource(name = "categoryJsonConverter")
    private CategoryJsonConverter converter;

    @Override
    public Optional<CategoryData> getCategoryById(Long id) {
        return categoryService.getCategoryById(id)
                .map(assembler::toModel);
    }

    @Override
    public Optional<CategoryData> createCategory(CategoryJson categoryJson) {
        CategoryModel categoryModel = converter.convert(categoryJson);
        return categoryService.createCategory(categoryModel)
                .map(assembler::toModel);
    }

    @Override
    public Optional<CategoryData> updateCategory(CategoryJson categoryJson, Long id) {
        CategoryModel categoryModel = converter.convert(categoryJson);
        return categoryService.updateCategory(categoryModel, id)
                .map(assembler::toModel);
    }

    @Override
    public Optional<CategoryData> patchCategory(CategoryJson categoryJson, Long id) {
        CategoryModel categoryModel = converter.convert(categoryJson);
        return categoryService.patchCategory(categoryModel, id)
                .map(assembler::toModel);
    }

    @Override
    public Optional<CategoryData> deleteCategory(Long id) {
        return categoryService.deleteCategory(id)
                .map(assembler::toModel);
    }


    @Override
    public CollectionModel<CategoryData> fetchAllCategories() {
        return assembler.toCollectionModel(categoryService.findAllCategories());
    }
}
