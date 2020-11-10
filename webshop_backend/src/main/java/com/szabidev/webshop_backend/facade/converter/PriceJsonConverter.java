package com.szabidev.webshop_backend.facade.converter;

import com.szabidev.webshop_backend.controller.dto.PriceJson;
import com.szabidev.webshop_backend.model.PriceModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("priceJsonConverter")
public class PriceJsonConverter implements Converter<PriceJson, PriceModel> {

    @Override
    public PriceModel convert(PriceJson source) {
        PriceModel priceModel = new PriceModel();
        priceModel.setValue(source.getValue());
        priceModel.setCurrency(source.getCurrency());
        return priceModel;
    }
}
