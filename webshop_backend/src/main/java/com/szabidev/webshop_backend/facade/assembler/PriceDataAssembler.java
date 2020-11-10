package com.szabidev.webshop_backend.facade.assembler;

import com.szabidev.webshop_backend.facade.dto.PriceData;
import com.szabidev.webshop_backend.model.PriceModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component("priceDataAssembler")
public class PriceDataAssembler implements RepresentationModelAssembler<PriceModel, PriceData> {

    @Override
    public PriceData toModel(PriceModel entity) {
        if (entity == null) {
            return null;
        }
        return convert(entity);
    }

    private PriceData convert(PriceModel entity) {
        PriceData priceData = new PriceData();
        priceData.setId(entity.getId());
        priceData.setCurrency(entity.getCurrency());
        priceData.setValue(entity.getValue());
        return priceData;
    }
}
