package com.szabidev.webshop_backend.facade;

import com.szabidev.webshop_backend.controller.dto.ProductJson;
import com.szabidev.webshop_backend.facade.dto.CategoryData;
import com.szabidev.webshop_backend.facade.dto.DeliveryModeData;
import com.szabidev.webshop_backend.facade.dto.ProductData;
import org.springframework.hateoas.CollectionModel;

import java.util.List;
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

    /**
     * Method to find all categories
     * @param id - id
     * @return {@link List<CategoryData>  }
     */
    CollectionModel<CategoryData> findAllCategoriesForProduct(Long id);

    /**
     * Method to add category to product
     * @param productId - product id
     * @param categoryId - category id
     * @return {@link Optional<ProductData>}
     */
    Optional<ProductData> addCategoryToProduct(Long productId, Long categoryId);

    /**
     * Method to remove category from product
     * @param productId - product id
     * @param categoryId - category id
     * @return {@link Optional<ProductData>}
     */
    Optional<ProductData> removeCategoryFromProduct(Long productId, Long categoryId);

    /**
     * Method to find all deliveryModes for product
     * @param id - product id
     * @return {@link CollectionModel<DeliveryModeData>}
     */
    CollectionModel<DeliveryModeData> findAllDeliveryModesForProduct(Long id);

    /**
     * Method to add delivery mode to product
     * @param productId - product id
     * @param deliveryId - delivery mode id
     * @return {@link Optional<ProductData>}
     */
    Optional<ProductData> addDeliveryModeToProduct(Long productId, Long deliveryId);

    /**
     * Method to remove delivery mode from product
     * @param productId - product id
     * @param deliveryId - delivery id
     * @return {@link Optional<ProductData>}
     */
    Optional<ProductData> removeDeliveryModeFromProduct(Long productId, Long deliveryId);

}
