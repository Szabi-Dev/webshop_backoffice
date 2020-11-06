package com.szabidev.webshop_backend.facade;

import com.szabidev.webshop_backend.controller.dto.ProductJson;
import com.szabidev.webshop_backend.facade.dto.ProductData;
import org.springframework.hateoas.CollectionModel;

import java.util.Optional;

/**
 * facade to transform product data
 */
public interface ProductFacade {

    CollectionModel<ProductData> findAllProducts();

    Optional<ProductData> getProductById(Long id);

    Optional<ProductData> createProduct(ProductJson productJson);
}
