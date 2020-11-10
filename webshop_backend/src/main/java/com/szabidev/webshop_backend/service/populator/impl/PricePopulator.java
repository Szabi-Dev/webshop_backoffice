package com.szabidev.webshop_backend.service.populator.impl;

import com.szabidev.webshop_backend.model.PriceModel;
import com.szabidev.webshop_backend.service.populator.Populator;
import org.springframework.stereotype.Component;

@Component("pricePopulator")
public class PricePopulator implements Populator<PriceModel, PriceModel> {

    @Override
    public void populatePut(PriceModel target, PriceModel source) {

    }

    @Override
    public void populatePatch(PriceModel target, PriceModel source) {
        if (source.getValue()!= null) target.setValue(source.getValue());
        if (source.getCurrency()!= null) target.setCurrency(source.getCurrency());
    }
}
