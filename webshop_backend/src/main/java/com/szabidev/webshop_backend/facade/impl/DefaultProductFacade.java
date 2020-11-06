package com.szabidev.webshop_backend.facade.impl;

import com.szabidev.webshop_backend.controller.dto.ProductJson;
import com.szabidev.webshop_backend.facade.ProductFacade;
import com.szabidev.webshop_backend.facade.assembler.ProductDataAssembler;
import com.szabidev.webshop_backend.facade.converter.ProductJsonConverter;
import com.szabidev.webshop_backend.facade.dto.ProductData;
import com.szabidev.webshop_backend.model.ProductModel;
import com.szabidev.webshop_backend.service.ProductService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Component("productFacade")
public class DefaultProductFacade implements ProductFacade {

    @Resource(name = "productService")
    private ProductService productService;

    @Resource(name = "productDataAssembler")
    private ProductDataAssembler productDataAssembler;

    @Resource(name = "productJsonConverter")
    private ProductJsonConverter productJsonConverter;

    @Override
    public CollectionModel<ProductData> findAllProducts() {
        return productDataAssembler.toCollectionModel(productService.findAllProducts());
    }

    @Override
    public Optional<ProductData> getProductById(Long id) {
        return productService.getProductById(id)
                .map(productDataAssembler::toModel);
    }

    @Override
    public Optional<ProductData> createProduct(ProductJson productJson) {
        ProductModel productModel = productJsonConverter.convert(productJson);
        return productService.createProduct(productModel).map(productDataAssembler::toModel);
    }

    @Override
    public Optional<ProductData> patchProduct(ProductJson productJson, Long id) {
        ProductModel productModel = productJsonConverter.convert(productJson);
        return productService.patchProduct(productModel,id).map(productDataAssembler::toModel) ;
    }

    @Override
    public Optional<ProductData> deleteProduct(Long id) {
        return productService.deleteProduct(id).map(productDataAssembler::toModel);
    }
}
