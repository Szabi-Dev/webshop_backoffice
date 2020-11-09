package com.szabidev.webshop_backend.dao;

import com.szabidev.webshop_backend.model.DeliveryModeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("deliveryModeRepository")
public interface DeliveryModeRepository extends JpaRepository<DeliveryModeModel, Long> {
    /**
     * Method to fetch delivery mode by code
     * @param code - code
     * @return {@link DeliveryModeModel}
     */
    Optional<DeliveryModeModel> findByCode(String code);
}
