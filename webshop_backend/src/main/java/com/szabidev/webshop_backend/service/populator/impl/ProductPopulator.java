package com.szabidev.webshop_backend.service.populator.impl;

import com.szabidev.webshop_backend.model.PriceModel;
import com.szabidev.webshop_backend.model.ProductLocalizedModel;
import com.szabidev.webshop_backend.model.ProductModel;
import com.szabidev.webshop_backend.service.populator.Populator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

@Component("productPopulator")
public class ProductPopulator implements Populator<ProductModel, ProductModel> {

    @Resource(name = "pricePopulator")
    private PricePopulator pricePopulator;

    @Override
    public void populatePut(ProductModel target, ProductModel source) {

    }

    @Override
    public void populatePatch(ProductModel target, ProductModel source) {
        if (source.getCode()!= null) target.setCode(source.getCode());

        populatePrice(target, source);

        for (Map.Entry<String, ProductLocalizedModel> localizedModelEntry : source.getLocalizations().entrySet()) {
            populateLocalizedEntries(target, localizedModelEntry);
        }
    }

    private void populatePrice(ProductModel target, ProductModel source) {
        if (source.getOneTimePrice() == null) {
            return;
        }
        if (target.getOneTimePrice() == null) {
            target.setOneTimePrice(new PriceModel());
        }
        pricePopulator.populatePatch(target.getOneTimePrice(), source.getOneTimePrice());
    }

    private void populateLocalizedEntries(ProductModel target, Map.Entry<String, ProductLocalizedModel> localizedModelEntry) {
        if (target.getLocalizations().containsKey(localizedModelEntry.getKey())) {
            target.getLocalizations().get(localizedModelEntry.getKey()).setLocale(localizedModelEntry.getValue().getLocale());
            if (localizedModelEntry.getValue().getName() != null) target.getLocalizations().get(localizedModelEntry.getKey()).setName(localizedModelEntry.getValue().getName());
            if (localizedModelEntry.getValue().getDescription() != null) target.getLocalizations().get(localizedModelEntry.getKey()).setDescription(localizedModelEntry.getValue().getDescription());
        } else {
            localizedModelEntry.getValue().setFkProduct(target);
            target.getLocalizations().put(localizedModelEntry.getKey(), localizedModelEntry.getValue());
        }
    }
}
