package com.szabidev.webshop_backend.service.populator.impl;

import com.szabidev.webshop_backend.model.CategoryLocalizedModel;
import com.szabidev.webshop_backend.model.DeliveryModeLocalizedModel;
import com.szabidev.webshop_backend.model.DeliveryModeModel;
import com.szabidev.webshop_backend.service.populator.Populator;

import java.util.Map;

public class DeliveryModePopulator implements Populator<DeliveryModeModel, DeliveryModeModel> {
    @Override
    public void populatePut(DeliveryModeModel target, DeliveryModeModel source) {

    }

    @Override
    public void populatePatch(DeliveryModeModel target, DeliveryModeModel source) {
        for (Map.Entry<String, DeliveryModeLocalizedModel> localizedModelEntry : source.getLocalizations().entrySet()) {
            if (target.getLocalizations().containsKey(localizedModelEntry.getKey())) {
                target.getLocalizations().get(localizedModelEntry.getKey()).setLocale(localizedModelEntry.getValue().getLocale());
                if (localizedModelEntry.getValue().getName() != null) target.getLocalizations().get(localizedModelEntry.getKey()).setName(localizedModelEntry.getValue().getName());
            } else {
                localizedModelEntry.getValue().setFkDeliveryMode(target);
                target.getLocalizations().put(localizedModelEntry.getKey(), localizedModelEntry.getValue());
            }

        }
    }
}
