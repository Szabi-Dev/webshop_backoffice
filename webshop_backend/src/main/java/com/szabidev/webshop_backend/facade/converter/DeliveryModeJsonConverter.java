package com.szabidev.webshop_backend.facade.converter;

import com.szabidev.webshop_backend.controller.dto.DeliveryModeJson;
import com.szabidev.webshop_backend.model.DeliveryModeLocalizedModel;
import com.szabidev.webshop_backend.model.DeliveryModeModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("deliveryModeJsonConverter")
public class DeliveryModeJsonConverter implements Converter<DeliveryModeJson, DeliveryModeModel> {

    @Override
    public DeliveryModeModel convert(DeliveryModeJson source) {
        DeliveryModeModel deliveryModeModel = new DeliveryModeModel();
        deliveryModeModel.setCode(source.getCode());
        deliveryModeModel.setLocalizations(new HashMap<>());
        populateDeliveryModeName(source, deliveryModeModel);
        return deliveryModeModel;
    }

    private void populateDeliveryModeName(DeliveryModeJson source, DeliveryModeModel target){
        for (Map.Entry<String, String> name: source.getName().entrySet()) {
            DeliveryModeLocalizedModel localization = getDeliveryLocalization(name.getKey(), target);
            localization.setName(name.getValue());
            target.getLocalizations().put(name.getKey(), localization);
        }
    }

    private DeliveryModeLocalizedModel getDeliveryLocalization(String lang, DeliveryModeModel target) {
        if (target.getLocalizations().containsKey(lang)) {
            return target.getLocalizations().get(lang);
        }
        DeliveryModeLocalizedModel newLocalization = new DeliveryModeLocalizedModel();
        newLocalization.setLocale(lang);
        newLocalization.setFkDeliveryMode(target);
        return newLocalization;
    }
}
