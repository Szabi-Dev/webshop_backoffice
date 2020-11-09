package com.szabidev.webshop_backend.model;

import javax.persistence.*;
import java.util.Locale;

@Entity
@Table(name = "DELIVERY_MODE_LOCALIZED")
public class DeliveryModeLocalizedModel {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "locale")
    private String locale;

    @Column(name = "name")
    private String name;

    @ManyToOne
    private DeliveryModeModel fkDeliveryMode;

    public DeliveryModeLocalizedModel(){}

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

    public DeliveryModeModel getFkDeliveryMode() {
        return fkDeliveryMode;
    }

    public void setFkDeliveryMode(DeliveryModeModel fkDeliveryMode) {
        this.fkDeliveryMode = fkDeliveryMode;
    }
}
