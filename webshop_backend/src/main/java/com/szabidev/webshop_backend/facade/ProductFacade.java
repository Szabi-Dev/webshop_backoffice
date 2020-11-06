package com.szabidev.webshop_backend.facade;

import com.szabidev.webshop_backend.controller.dto.ProductJson;
import com.szabidev.webshop_backend.facade.dto.ProductData;
import org.springframework.hateoas.CollectionModel;

import java.util.Optional;

/**
 * Facade to transform product data
 */
public interface ProductFacade {

    /**
     * Method to fetch all products
     *
     * @return {@link CollectionModel<ProductData>}
     */
    CollectionModel<ProductData> findAllProducts();

    /**
     * Method to get product by id
     *
     * @param id - product id
     * @return {@link Optional<ProductData>}
     */
    Optional<ProductData> getProductById(Long id);

    /**
     * Method to create a product
     *
     * @param productJson {@link ProductJson}
     * @return {@link Optional<ProductData>}
     */
    Optional<ProductData> createProduct(ProductJson productJson);

    /**
     * Method to patch product
     *
     * @param productJson {@link ProductJson}
     * @param id product id
     * @return {@link Optional<ProductData>}
     */
    Optional<ProductData> patchProduct(ProductJson productJson, Long id);

    /**
     * Method to delete products
     * @param id product id
     * @return {@link Optional<ProductData>}
     */
    Optional<ProductData> deleteProduct(Long id);
}
