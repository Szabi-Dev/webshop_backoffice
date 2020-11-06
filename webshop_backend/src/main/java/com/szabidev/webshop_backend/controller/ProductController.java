package com.szabidev.webshop_backend.controller;

import com.szabidev.webshop_backend.facade.ProductFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
