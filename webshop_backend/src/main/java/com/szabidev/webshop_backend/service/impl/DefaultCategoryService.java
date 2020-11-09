package com.szabidev.webshop_backend.service.impl;

import com.szabidev.webshop_backend.dao.CategoryRepository;
import com.szabidev.webshop_backend.model.CategoryModel;
import com.szabidev.webshop_backend.service.CategoryService;
import com.szabidev.webshop_backend.service.populator.impl.CategoryPopulator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service("categoryService")
public class DefaultCategoryService implements CategoryService {

    @Resource(name = "categoryRepository")
    private CategoryRepository categoryRepository;

    @Resource(name = "categoryPopulator")
    private CategoryPopulator categoryPopulator;

    @Override
    public List<CategoryModel> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<CategoryModel> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Optional<CategoryModel> createCategory(CategoryModel categoryModel) {
        if (categoryRepository.findByCode(categoryModel.getCode()).isPresent()) {
            return Optional.empty();
        }
        return Optional.of(categoryRepository.save(categoryModel));
    }

    @Override
    public Optional<CategoryModel> patchCategory(CategoryModel categoryModel, Long id) {
        Optional<CategoryModel> modelToBeUpdated = categoryRepository.findById(id);
        if (!modelToBeUpdated.isPresent()) {
            return Optional.empty();
        }
        categoryPopulator.populatePatch(modelToBeUpdated.get(), categoryModel);
        return Optional.of(categoryRepository.save(modelToBeUpdated.get()));
    }

    @Override
    public Optional<CategoryModel> deleteCategory( Long id) {
        Optional<CategoryModel> categoryModel = categoryRepository.findById(id);
        if (!categoryModel.isPresent()) {
            return Optional.empty();
        }
        categoryRepository.delete(categoryModel.get());
        return categoryModel;
    }
}
