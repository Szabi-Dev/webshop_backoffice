package com.szabidev.webshop_backend.model;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "PRODUCT_TABLE")
public class ProductModel {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "code", unique = true)
    private String code;

    @OneToMany(mappedBy = "fkProduct", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @MapKey(name = "locale")
    Map<String, ProductLocalizedModel> localizations;

    public ProductModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Map<String, ProductLocalizedModel> getLocalizations() {
        return localizations;
    }

    public void setLocalizations(Map<String, ProductLocalizedModel> localizations) {
        this.localizations = localizations;
    }
}
