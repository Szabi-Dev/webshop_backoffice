package com.szabidev.webshop_backend.facade.assembler;

import com.szabidev.webshop_backend.controller.ProductController;
import com.szabidev.webshop_backend.facade.dto.ProductData;
import com.szabidev.webshop_backend.model.ProductLocalizedModel;
import com.szabidev.webshop_backend.model.ProductModel;
import com.szabidev.webshop_backend.service.LocalizationService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component("productDataAssembler")
public class ProductDataAssembler implements RepresentationModelAssembler<ProductModel,ProductData > {

    @Resource(name = "localizationService")
    private LocalizationService localizationService;

    @Resource(name = "priceDataAssembler")
    private PriceDataAssembler priceDataAssembler;

    @Resource(name = "mediaDataAssembler")
    private MediaDataAssembler mediaDataAssembler;

    private static final String ALL_PRODUCTS_REL = "products";
    private static final String CREATE_PRODUCT_REL = "create";
    private static final String CATEGORIES = "categories";


    @Override
    public ProductData toModel(ProductModel entity) {
        ProductData productData = convert(entity);
        populateSelfLink(productData);
        populateLinkToAll(productData, ALL_PRODUCTS_REL);
        populateLinkToCategories(productData, CATEGORIES);
        return productData;
    }

    @Override
    public CollectionModel<ProductData> toCollectionModel(Iterable<? extends ProductModel> entities) {
        List<ProductData> productDataList = new ArrayList<>();
        entities.forEach(entity -> productDataList.add(toModel(entity)));
        return CollectionModel.of(productDataList,
                linkTo(methodOn(ProductController.class).findAllProducts()).withSelfRel(),
                linkTo(methodOn(ProductController.class).createProduct(null)).withRel(CREATE_PRODUCT_REL));
    }

    private ProductData convert(ProductModel productModel) {
        ProductData productData = new ProductData();
        String lang = localizationService.getLocalization();
        productData.setId(productModel.getId());
        productData.setCode(productModel.getCode());

        productData.setOneTimePrice(priceDataAssembler.toModel(productModel.getOneTimePrice()));
        productData.setMainImage(mediaDataAssembler.toModel(productModel.getMainImage()));

        if (productModel.getLocalizations().get(lang) == null){
            return productData;
        }
        ProductLocalizedModel localizedModel = productModel.getLocalizations().get(lang);

        productData.setName(localizedModel.getName());
        productData.setDescription(localizedModel.getDescription());
        return productData;
    }

    private void populateSelfLink(ProductData productData){
        productData.add(linkTo(methodOn(ProductController.class).getProductById(productData.getId())).withSelfRel());
    }

    private void populateLinkToAll(ProductData productData, String rel){
        productData.add(linkTo(methodOn(ProductController.class).findAllProducts()).withRel(rel));
    }

    private void populateLinkToCategories(ProductData productData, String rel){
        productData.add(linkTo(methodOn(ProductController.class).getAllCategories(productData.getId())).withRel(rel));
    }
}
