package com.szabidev.webshop_backend.dao;

import com.szabidev.webshop_backend.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<ProductModel, Long> {

    /**
     * Find product by code
     * @param code - code
     * @return {@link Optional<ProductModel>}
     */
    Optional<ProductModel> findByCode(String code);
}
