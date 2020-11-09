package com.szabidev.webshop_backend.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "CATEGORY_MODEL")
public class CategoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "code", unique = true)
    private String code;

    @OneToMany(mappedBy = "fkCategory", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @MapKey(name = "locale")
    private Map<String, CategoryLocalizedModel> localizations = new HashMap<>();

    @ManyToMany(mappedBy = "categories")
    private Collection<ProductModel> products;

    public CategoryModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<String, CategoryLocalizedModel> getLocalizations() {
        return localizations;
    }

    public void setLocalizations(Map<String, CategoryLocalizedModel> localizations) {
        this.localizations = localizations;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Collection<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(Collection<ProductModel> products) {
        this.products = products;
    }
}
