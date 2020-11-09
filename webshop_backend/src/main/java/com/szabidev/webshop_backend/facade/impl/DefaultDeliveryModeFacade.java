package com.szabidev.webshop_backend.facade.impl;

import com.szabidev.webshop_backend.controller.dto.DeliveryModeJson;
import com.szabidev.webshop_backend.facade.DeliveryModeFacade;
import com.szabidev.webshop_backend.facade.assembler.DeliveryModeDataAssembler;
import com.szabidev.webshop_backend.facade.converter.DeliveryModeJsonConverter;
import com.szabidev.webshop_backend.facade.dto.DeliveryModeData;
import com.szabidev.webshop_backend.model.DeliveryModeModel;
import com.szabidev.webshop_backend.service.DeliveryModeService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;

@Component("deliveryModeFacade")
public class DefaultDeliveryModeFacade implements DeliveryModeFacade {

    @Resource(name = "deliveryModeService")
    private DeliveryModeService deliveryModeService;

    @Resource(name = "deliveryModeAssembler")
    private DeliveryModeDataAssembler deliveryModeDataAssembler;

    @Resource(name = "deliveryModeJsonConverter")
    private DeliveryModeJsonConverter deliveryModeJsonConverter;

    @Override
    public Optional<DeliveryModeData> getDeliveryModeById(Long id) {
        return deliveryModeService.getDeliveryModeById(id).map(deliveryModeDataAssembler::toModel);
    }

    @Override
    public CollectionModel<DeliveryModeData> findAllDeliveryModes() {
        return deliveryModeDataAssembler.toCollectionModel(deliveryModeService.findAllDeliveryModes());
    }

    @Override
    public Optional<DeliveryModeData> deleteDeliveryMode(Long id) {
        return deliveryModeService.deleteDeliveryMode(id).map(deliveryModeDataAssembler::toModel);
    }

    @Override
    public Optional<DeliveryModeData> createDeliveryMode(DeliveryModeJson deliveryModeJson) {
        DeliveryModeModel deliveryModeModel = deliveryModeJsonConverter.convert(deliveryModeJson);
        return deliveryModeService.createDeliveryMode(deliveryModeModel).map(deliveryModeDataAssembler::toModel);
    }

    @Override
    public Optional<DeliveryModeData> patchDeliveryMode(DeliveryModeJson deliveryModeJson, Long id) {
        DeliveryModeModel deliveryModeModel = deliveryModeJsonConverter.convert(deliveryModeJson);
        return deliveryModeService.patchDeliveryMode(deliveryModeModel, id).map(deliveryModeDataAssembler::toModel);
    }


}
