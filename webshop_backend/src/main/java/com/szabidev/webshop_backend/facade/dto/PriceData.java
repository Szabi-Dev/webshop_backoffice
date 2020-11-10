package com.szabidev.webshop_backend.facade.dto;

import org.springframework.hateoas.RepresentationModel;

public class PriceData extends RepresentationModel<PriceData> {

    private Long id;
    private Double value;
    private String currency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
