package com.szabidev.webshop_backend.facade;

import com.szabidev.webshop_backend.controller.dto.DeliveryModeJson;
import com.szabidev.webshop_backend.facade.dto.DeliveryModeData;
import org.springframework.hateoas.CollectionModel;

import java.util.List;
import java.util.Optional;

/**
 * Facade to transform results for frontend
 */
public interface DeliveryModeFacade {
    Optional<DeliveryModeData>  getDeliveryModeById(Long id);

    CollectionModel<DeliveryModeData> findAllDeliveryModes();

    Optional<DeliveryModeData> deleteDeliveryMode(Long id);

    Optional<DeliveryModeData> createDeliveryMode(DeliveryModeJson deliveryModeJson);

    Optional<DeliveryModeData> patchDeliveryMode(DeliveryModeJson deliveryModeJson, Long id);
}
