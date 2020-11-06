package com.szabidev.webshop_backend.facade.assembler;

import com.szabidev.webshop_backend.facade.dto.ProductData;
import com.szabidev.webshop_backend.model.ProductModel;
import com.szabidev.webshop_backend.service.LocalizationService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component("productDataAssembler")
public class ProductDataAssembler implements RepresentationModelAssembler<ProductModel,ProductData > {

    @Resource(name = "localizationService")
    private LocalizationService localizationService;

    private static final String ALL_PRODUCTS_REL = "products";
    private static final String CREATE_CATEGORY_REL = "create";


    @Override
    public ProductData toModel(ProductModel entity) {
        ProductData productData = convert(entity);
        return productData;
    }

    @Override
    public CollectionModel<ProductData> toCollectionModel(Iterable<? extends ProductModel> entities) {
        List<ProductData> productDataList = new ArrayList<>();
        entities.forEach(entity -> productDataList.add(toModel(entity)));
        return CollectionModel.of(productDataList);
    }

    private ProductData convert(ProductModel productModel) {
        ProductData productData = new ProductData();
        String lang = localizationService.getLocalization();
        productData.setId(productModel.getId());
        productData.setCode(productModel.getCode());
        if (productModel.getLocalizations().get(lang) == null){
            return productData;
        }
        productData.setName(productModel.getLocalizations().get(lang).getName());
        productData.setDescription(productModel.getLocalizations().get(lang).getDescription());
        return productData;
    }
}
