package com.szabidev.webshop_backend.controller;

import com.szabidev.webshop_backend.controller.dto.CategoryJson;
import com.szabidev.webshop_backend.facade.CategoryFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource(name= "categoryFacade")
    private CategoryFacade categoryFacade;

    @GetMapping
    public ResponseEntity<?> fetchAllCategories(){
        return ResponseEntity.ok(categoryFacade.fetchAllCategories());
    }

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CategoryJson categoryJson) {
        return categoryFacade.createCategory(categoryJson)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.ok().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id){
        return categoryFacade.getCategoryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

}