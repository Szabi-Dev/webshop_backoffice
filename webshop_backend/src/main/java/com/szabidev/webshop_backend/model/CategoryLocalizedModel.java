package com.szabidev.webshop_backend.model;

import javax.persistence.*;

public class CategoryLocalizedModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "locale")
    private String locale;

    @Column(name = "category_name")
    private String categoryName;

    @ManyToOne
    @JoinColumn(name = "Id")
    private CategoryModel fkCategory;

    public CategoryLocalizedModel(){}

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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public CategoryModel getFkCategory() {
        return fkCategory;
    }

    public void setFkCategory(CategoryModel fkCategory) {
        this.fkCategory = fkCategory;
    }
}
