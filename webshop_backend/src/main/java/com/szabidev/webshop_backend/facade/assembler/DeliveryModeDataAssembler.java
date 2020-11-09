package com.szabidev.webshop_backend.facade.assembler;

import com.szabidev.webshop_backend.controller.DeliveryModeController;
import com.szabidev.webshop_backend.facade.dto.DeliveryModeData;
import com.szabidev.webshop_backend.model.DeliveryModeModel;
import com.szabidev.webshop_backend.service.LocalizationService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component("deliveryModeAssembler")
public class DeliveryModeDataAssembler implements RepresentationModelAssembler<DeliveryModeModel, DeliveryModeData> {

    @Resource(name = "localizationService")
    private LocalizationService localizationService;

    private static final String ALL_DELIVERY_MODE_REL = "delivery";
    private static final String CREATE_DELIVERY_MODE_REL = "create";

    @Override
    public DeliveryModeData toModel(DeliveryModeModel entity) {
        DeliveryModeData deliveryModeData = convert(entity);
        populateLinkToAll(deliveryModeData, ALL_DELIVERY_MODE_REL);
        populateSelfLink(deliveryModeData);
        return deliveryModeData;
    }

    @Override
    public CollectionModel<DeliveryModeData> toCollectionModel(Iterable<? extends DeliveryModeModel> entities) {
        List<DeliveryModeData> deliveryModeDataList = new ArrayList<>();
        entities.forEach(deliveryMode -> deliveryModeDataList.add(convert(deliveryMode)));
        return CollectionModel.of(deliveryModeDataList,
                linkTo(methodOn(DeliveryModeController.class).createDeliveryMode(null)).withRel(CREATE_DELIVERY_MODE_REL),
                linkTo(methodOn(DeliveryModeController.class).findAllDeliveryMode()).withSelfRel());
    }

    private DeliveryModeData convert(DeliveryModeModel entity){
        DeliveryModeData deliveryModeData = new DeliveryModeData();
        String lang = localizationService.getLocalization();
        deliveryModeData.setId(entity.getId());
        deliveryModeData.setCode(entity.getCode());
        if (entity.getLocalizations().get(lang) == null){
            return deliveryModeData;
        }
        deliveryModeData.setName(entity.getLocalizations().get(lang).getName());
        return deliveryModeData;
    }

    private void populateSelfLink(DeliveryModeData deliveryModeData){
        deliveryModeData.add(linkTo(methodOn(DeliveryModeController.class).getDeliveryById(deliveryModeData.getId())).withSelfRel());
    }

    private void populateLinkToAll(DeliveryModeData deliveryModeData, String rel){
        deliveryModeData.add(linkTo(methodOn(DeliveryModeController.class).getDeliveryById(deliveryModeData.getId())).withRel(rel));
    }


}
