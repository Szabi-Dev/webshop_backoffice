package com.szabidev.webshop_backend.facade.converter;

import com.szabidev.webshop_backend.controller.dto.CategoryJson;
import com.szabidev.webshop_backend.model.CategoryLocalizedModel;
import com.szabidev.webshop_backend.model.CategoryModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("categoryJsonConverter")
public class CategoryJsonConverter implements Converter<CategoryJson, CategoryModel> {


    @Override
    public CategoryModel convert(CategoryJson source) {
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setLocalizations(new HashMap<>());
        populateCategoryName(source, categoryModel);
        return categoryModel;
    }

    private void populateCategoryName(CategoryJson source, CategoryModel target){
        for (Map.Entry<String, String> name: source.getName().entrySet()) {
            CategoryLocalizedModel localization = getCategoryLocalization(name.getKey(), target);
            localization.setCategoryName(name.getValue());
            target.getLocalizations().put(name.getKey(), localization);
         }
    }

    private CategoryLocalizedModel getCategoryLocalization(String lang, CategoryModel target) {
        if (target.getLocalizations().containsKey(lang)) {
            return target.getLocalizations().get(lang);
        }
        CategoryLocalizedModel newLocalization = new CategoryLocalizedModel();
        newLocalization.setLocale(lang);
        newLocalization.setFkCategory(target);
        return newLocalization;
    }
}

