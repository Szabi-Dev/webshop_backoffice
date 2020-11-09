package com.szabidev.webshop_backend.service.populator.impl;

import com.szabidev.webshop_backend.model.CategoryLocalizedModel;
import com.szabidev.webshop_backend.model.CategoryModel;
import com.szabidev.webshop_backend.service.populator.Populator;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component("categoryPopulator")
public class CategoryPopulator implements Populator<CategoryModel, CategoryModel> {

    @Override
    public void populatePut(CategoryModel target, CategoryModel source) {
       target.setLocalizations(source.getLocalizations());
    }

    @Override
    public void populatePatch(CategoryModel target, CategoryModel source) {
        for (Map.Entry<String, CategoryLocalizedModel> localizedModelEntry : source.getLocalizations().entrySet()) {
            if (target.getLocalizations().containsKey(localizedModelEntry.getKey())) {
                target.getLocalizations().get(localizedModelEntry.getKey()).setLocale(localizedModelEntry.getValue().getLocale());
                if (localizedModelEntry.getValue().getCategoryName() != null) target.getLocalizations().get(localizedModelEntry.getKey()).setCategoryName(localizedModelEntry.getValue().getCategoryName());
            } else {
                localizedModelEntry.getValue().setFkCategory(target);
                target.getLocalizations().put(localizedModelEntry.getKey(), localizedModelEntry.getValue());
            }

        }
    }
}
