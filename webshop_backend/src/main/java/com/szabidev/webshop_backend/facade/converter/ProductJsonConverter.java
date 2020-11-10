package com.szabidev.webshop_backend.facade.converter;

import com.szabidev.webshop_backend.controller.dto.CategoryJson;
import com.szabidev.webshop_backend.controller.dto.ProductJson;
import com.szabidev.webshop_backend.model.CategoryLocalizedModel;
import com.szabidev.webshop_backend.model.CategoryModel;
import com.szabidev.webshop_backend.model.ProductLocalizedModel;
import com.szabidev.webshop_backend.model.ProductModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Component("productJsonConverter")
public class ProductJsonConverter implements Converter<ProductJson, ProductModel> {

    @Resource( name = "priceJsonConverter")
    private PriceJsonConverter priceJsonConverter;

    @Override
    public ProductModel convert(ProductJson source) {
        ProductModel productModel = new ProductModel();
        productModel.setCode(source.getCode());
        productModel.setLocalizations(new HashMap<>());

        productModel.setOneTimePrice(priceJsonConverter.convert(source.getOneTimePrice()));

        if (source.getName()!= null) populateName(source, productModel);
        if (source.getDescription() != null) populateDescription(source, productModel);
        return productModel;
    }

    private void populateDescription(ProductJson source, ProductModel target){
        for (Map.Entry<String, String> description: source.getDescription().entrySet()) {
            ProductLocalizedModel localization = getProductLocalization(description.getKey(), target);
            localization.setDescription(description.getValue());
            target.getLocalizations().put(description.getKey(), localization);
        }
    }

    private void populateName(ProductJson source, ProductModel target){
        for (Map.Entry<String, String> name: source.getName().entrySet()) {
            ProductLocalizedModel localization = getProductLocalization(name.getKey(), target);
            localization.setName(name.getValue());
            target.getLocalizations().put(name.getKey(), localization);
        }
    }

    private ProductLocalizedModel getProductLocalization(String lang, ProductModel target) {
        if (target.getLocalizations().containsKey(lang)) {
            return target.getLocalizations().get(lang);
        }
        ProductLocalizedModel newLocalization = new ProductLocalizedModel();
        newLocalization.setLocale(lang);
        newLocalization.setFkProduct(target);
        return newLocalization;
    }
}
