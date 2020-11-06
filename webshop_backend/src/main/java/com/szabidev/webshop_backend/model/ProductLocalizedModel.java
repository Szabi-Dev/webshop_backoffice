package com.szabidev.webshop_backend.model;

import javax.persistence.*;

@Entity
@Table (name = "PRODUCT_LOCALIZED_TABLE")
public class ProductLocalizedModel {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "locale")
    private String locale;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "fkProduct")
    private ProductModel fkProduct;

    public ProductLocalizedModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductModel getFkProduct() {
        return fkProduct;
    }

    public void setFkProduct(ProductModel fkProduct) {
        this.fkProduct = fkProduct;
    }
}
