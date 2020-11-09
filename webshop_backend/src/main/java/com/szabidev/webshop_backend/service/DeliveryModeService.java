package com.szabidev.webshop_backend.service;

import com.szabidev.webshop_backend.model.DeliveryModeModel;

import java.util.List;
import java.util.Optional;

/**
 * Service to perform delivery mode specific operations
 */
public interface DeliveryModeService {

    Optional<DeliveryModeModel> getDeliveryModeById(Long id);

    List<DeliveryModeModel> findAllDeliveryModes();

    Optional<DeliveryModeModel> createDeliveryMode(DeliveryModeModel deliveryModeModel);

    Optional<DeliveryModeModel> patchDeliveryMode(DeliveryModeModel deliveryModeModel, Long id);

    Optional<DeliveryModeModel> deleteDeliveryMode(Long id);
}
