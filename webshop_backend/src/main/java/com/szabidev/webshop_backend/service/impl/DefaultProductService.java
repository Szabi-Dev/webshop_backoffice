package com.szabidev.webshop_backend.service.impl;

import com.szabidev.webshop_backend.dao.ProductRepository;
import com.szabidev.webshop_backend.model.ProductModel;
import com.szabidev.webshop_backend.service.ProductService;
import com.szabidev.webshop_backend.service.populator.impl.ProductPopulator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service("productService")
public class DefaultProductService implements ProductService {

    @Resource(name = "productRepository")
    private ProductRepository productRepository;

    @Resource(name = "productPopulator")
    private ProductPopulator productPopulator;

    @Override
    public List<ProductModel> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<ProductModel> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Optional<ProductModel> createProduct(ProductModel productModel) {
        Optional<ProductModel> product = productRepository.findByCode(productModel.getCode());
        if (product.isPresent()) {
            return Optional.empty();
        }
        return Optional.of(productRepository.save(productModel));
    }

    @Override
    public Optional<ProductModel> patchProduct(ProductModel productModel, Long id) {
        Optional<ProductModel> productToBeUpdated = productRepository.findById(id);
        if (!productToBeUpdated.isPresent()) {
            return Optional.empty();
        }
        productPopulator.populatePatch(productToBeUpdated.get(), productModel);
        return Optional.of(productRepository.save(productToBeUpdated.get()));
    }

    @Override
    public Optional<ProductModel> deleteProduct(Long id) {
        Optional<ProductModel> product = productRepository.findById(id);
        if (!product.isPresent()) {
            return Optional.empty();
        }
        productRepository.delete(product.get());
        return product;
    }
}
