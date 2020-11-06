package com.szabidev.webshop_backend.model;

import com.szabidev.webshop_backend.model.util.LocaleProvider;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "CATEGORY_MODEL")
public class CategoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "fkCategory", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @MapKey(name = "locale")
    private Map<String, CategoryLocalizedModel> localizations = new HashMap<>();

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
}
