package com.szabidev.webshop_backend.controller;

import com.szabidev.webshop_backend.controller.dto.ProductJson;
import com.szabidev.webshop_backend.facade.ProductFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource(name = "productFacade")
    private ProductFacade productFacade;

    @GetMapping
    public ResponseEntity<?> findAllProducts(){
        return ResponseEntity.ok( productFacade.findAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id){
        return productFacade.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.ok().build());
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductJson productJson){
        return productFacade.createProduct(productJson)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.ok().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patchProduct(@PathVariable Long id, @RequestBody ProductJson productJson) {
        return productFacade.patchProduct(productJson, id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.ok().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        return productFacade.deleteProduct( id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.ok().build());
    }

    @GetMapping("/{productId}/category")
    public ResponseEntity<?> getAllCategories(@PathVariable Long productId){
        return ResponseEntity.ok(productFacade.findAllCategoriesForProduct(productId));
    }

    @PatchMapping("/{productId}/category/{categoryId}")
    public ResponseEntity<?> addCategoryToProduct(@PathVariable Long productId, @PathVariable Long categoryId) {
        return productFacade.addCategoryToProduct(productId, categoryId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.ok().build());
    }

    @DeleteMapping("/{productId}/category/{categoryId}")
    public ResponseEntity<?> deleteCategoryFromProduct(@PathVariable Long productId, @PathVariable Long categoryId) {
        return productFacade.removeCategoryFromProduct(productId, categoryId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.ok().build());
    }
}
