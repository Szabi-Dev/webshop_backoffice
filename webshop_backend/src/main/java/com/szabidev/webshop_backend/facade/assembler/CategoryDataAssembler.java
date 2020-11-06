package com.szabidev.webshop_backend.facade.assembler;

import com.szabidev.webshop_backend.facade.dto.CategoryData;
import com.szabidev.webshop_backend.model.CategoryModel;
import com.szabidev.webshop_backend.service.LocalizationService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component("categoryDataAssembler")
public class CategoryDataAssembler implements RepresentationModelAssembler<CategoryModel, CategoryData> {

    @Resource(name = "localizationService")
    private LocalizationService localizationService;


    @Override
    public CategoryData toModel(CategoryModel entity) {
        CategoryData categoryData = convert(entity);
        return categoryData;
    }

    @Override
    public CollectionModel<CategoryData> toCollectionModel(Iterable<? extends CategoryModel> entities) {
        List<CategoryData> categoryDataList = new ArrayList<>();
        entities.forEach(entity -> categoryDataList.add(this.convert(entity)));
        return CollectionModel.of(categoryDataList);
    }

    private CategoryData convert(CategoryModel categoryModel) {
        CategoryData categoryData = new CategoryData();
        String lang = localizationService.getLocalization();
        categoryData.setId(categoryModel.getId());
        categoryData.setName(categoryModel.getLocalizations().get(lang).getCategoryName());
        return categoryData;
    }
}
