package com.szabidev.webshop_backend.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "DELIVERY_MODE")
public class DeliveryModeModel {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "code", unique = true)
    private String code;

    @OneToMany(mappedBy = "fkDeliveryMode", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @MapKey(name = "locale")
    private Map<String, DeliveryModeLocalizedModel> localizations = new HashMap<>();

    public DeliveryModeModel() {
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

    public Map<String, DeliveryModeLocalizedModel> getLocalizations() {
        return localizations;
    }

    public void setLocalizations(Map<String, DeliveryModeLocalizedModel> localizations) {
        this.localizations = localizations;
    }
}
