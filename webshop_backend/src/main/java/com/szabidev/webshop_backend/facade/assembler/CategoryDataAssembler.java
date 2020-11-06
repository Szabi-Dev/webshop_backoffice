package com.szabidev.webshop_backend.facade.assembler;

import com.szabidev.webshop_backend.controller.CategoryController;
import com.szabidev.webshop_backend.controller.PrivilegeController;
import com.szabidev.webshop_backend.controller.RoleController;
import com.szabidev.webshop_backend.facade.dto.CategoryData;
import com.szabidev.webshop_backend.facade.dto.RoleData;
import com.szabidev.webshop_backend.model.CategoryModel;
import com.szabidev.webshop_backend.service.LocalizationService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component("categoryDataAssembler")
public class CategoryDataAssembler implements RepresentationModelAssembler<CategoryModel, CategoryData> {

    @Resource(name = "localizationService")
    private LocalizationService localizationService;

    private static final String ALL_CATEGORIES_REL = "roles";
    private static final String CREATE_CATEGORY_REL = "create";

    @Override
    public CategoryData toModel(CategoryModel entity) {
        CategoryData categoryData = convert(entity);
        populateSelfLink(categoryData);
        populateLinkToAll(categoryData, ALL_CATEGORIES_REL);
        return categoryData;
    }

    @Override
    public CollectionModel<CategoryData> toCollectionModel(Iterable<? extends CategoryModel> entities) {
        List<CategoryData> categoryDataList = new ArrayList<>();
        entities.forEach(entity -> categoryDataList.add(this.convert(entity)));
        return CollectionModel.of(categoryDataList,
                linkTo(methodOn(CategoryController.class).fetchAllCategories()).withSelfRel(),
                linkTo(methodOn(CategoryController.class).createCategory(null)).withRel(CREATE_CATEGORY_REL));
    }

    private CategoryData convert(CategoryModel categoryModel) {
        CategoryData categoryData = new CategoryData();
        String lang = localizationService.getLocalization();
        categoryData.setId(categoryModel.getId());
        if (categoryModel.getLocalizations().get(lang) == null){
            return categoryData;
        }

        categoryData.setName(categoryModel.getLocalizations().get(lang).getCategoryName());
        return categoryData;
    }

    private void populateSelfLink(CategoryData categoryData){
        categoryData.add(linkTo(methodOn(CategoryController.class).getCategoryById(categoryData.getId())).withSelfRel());
    }

    private void populateLinkToAll(CategoryData categoryData, String rel){
        categoryData.add(linkTo(methodOn(CategoryController.class).fetchAllCategories()).withRel(rel));
    }


}
