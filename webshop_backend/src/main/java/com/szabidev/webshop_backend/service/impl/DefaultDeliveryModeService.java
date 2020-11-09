package com.szabidev.webshop_backend.service.impl;

import com.szabidev.webshop_backend.dao.DeliveryModeRepository;
import com.szabidev.webshop_backend.model.DeliveryModeModel;
import com.szabidev.webshop_backend.service.DeliveryModeService;
import com.szabidev.webshop_backend.service.populator.impl.DeliveryModePopulator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service("deliveryModeService")
public class DefaultDeliveryModeService implements DeliveryModeService {

    @Resource(name = "deliveryModeRepository")
    private DeliveryModeRepository deliveryModeRepository;

    @Resource(name = "deliveryModePopulator")
    private DeliveryModePopulator populator;

    @Override
    public Optional<DeliveryModeModel> getDeliveryModeById(Long id) {
        return deliveryModeRepository.findById(id);
    }

    @Override
    public List<DeliveryModeModel> findAllDeliveryModes() {
        return deliveryModeRepository.findAll();
    }

    @Override
    public Optional<DeliveryModeModel> createDeliveryMode(DeliveryModeModel deliveryModeModel) {
        Optional<DeliveryModeModel> deliveryMode = deliveryModeRepository.findByCode(deliveryModeModel.getCode());
        if (deliveryMode.isPresent()) {
            return Optional.empty();
        }
        return Optional.of(deliveryModeRepository.save(deliveryModeModel));
    }

    @Override
    public Optional<DeliveryModeModel> patchDeliveryMode(DeliveryModeModel deliveryModeModel, Long id) {
        Optional<DeliveryModeModel> deliveryModeToBeUpdated = deliveryModeRepository.findById(id);
        if (!deliveryModeToBeUpdated.isPresent()) {
            return Optional.empty();
        }
        populator.populatePatch(deliveryModeToBeUpdated.get(), deliveryModeModel);
        return Optional.of(deliveryModeRepository.save(deliveryModeToBeUpdated.get()));
    }

    @Override
    public Optional<DeliveryModeModel> deleteDeliveryMode(Long id) {
        Optional<DeliveryModeModel> deliveryModeModel = deliveryModeRepository.findById(id);
        if (!deliveryModeModel.isPresent()) {
            return Optional.empty();
        }
        deliveryModeRepository.deleteById(id);
        return deliveryModeModel;
    }
}
