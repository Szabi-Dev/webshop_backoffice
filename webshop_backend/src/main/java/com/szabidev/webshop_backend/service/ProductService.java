package com.szabidev.webshop_backend.service;

import com.szabidev.webshop_backend.model.ProductModel;

import java.util.List;
import java.util.Optional;

/**
 * Interface to provide product specific operations
 */
public interface ProductService {

    List<ProductModel> findAllProducts();

    Optional<ProductModel> getProductById(Long id);

    Optional<ProductModel> createProduct(ProductModel productModel);

    Optional<ProductModel> patchProduct(ProductModel productModel, Long id);

    Optional<ProductModel> deleteProduct(Long id);
}
