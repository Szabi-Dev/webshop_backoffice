package com.szabidev.webshop_backend.service;

import com.szabidev.webshop_backend.model.CategoryModel;
import com.szabidev.webshop_backend.model.DeliveryModeModel;
import com.szabidev.webshop_backend.model.ProductModel;

import java.util.List;
import java.util.Optional;

/**
 * Interface to provide product specific operations
 */
public interface ProductService {

    /**
     * Method to find all product
     *
     * @return {@link List<ProductModel>}
     */
    List<ProductModel> findAllProducts();

    /**
     * Method to get product by id
     * @param id product id
     * @return {@link Optional<ProductModel>}
     */
    Optional<ProductModel> getProductById(Long id);

    /**
     * Method to create a product
     * @param productModel {@link ProductModel}
     * @return {@link Optional<ProductModel>}
     */
    Optional<ProductModel> createProduct(ProductModel productModel);

    /**
     * Method to patch product
     * @param productModel {@link ProductModel}
     * @param id product id
     * @return {@link Optional<ProductModel>}
     */
    Optional<ProductModel> patchProduct(ProductModel productModel, Long id);

    /**
     * Method to delete product
     * @param id - product id
     * @return {@link Optional<ProductModel>}
     */
    Optional<ProductModel> deleteProduct(Long id);

    /**
     * Method to fetch all categories for product
     * @param id - product id
     * @return {@link List<CategoryModel>}
     */
    List<CategoryModel> findAllCategoriesForProduct(Long id);

    /**
     * Add category yo product
     * @param id - id
     * @param categoryModel - {@link CategoryModel}
     * @return
     */
    Optional<ProductModel> addCategoryToProduct(Long id, CategoryModel categoryModel);

    /**
     * Remove category from product
     * @param id - id
     * @param categoryModel {@link CategoryModel}
     * @return {@link Optional<ProductModel>}
     */
    Optional<ProductModel> removeCategoryFromProduct(Long id, CategoryModel categoryModel);


    List<DeliveryModeModel> findAllDeliveryModesForProduct(Long id);

    Optional<ProductModel> addDeliveryModeToProduct(Long id, DeliveryModeModel deliveryModeModel);

    Optional<ProductModel> removeDeliveryModeFromProduct(Long id, DeliveryModeModel deliveryModeModel);

}
