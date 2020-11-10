package com.szabidev.webshop_backend.controller.dto;

public class PriceJson {

    private Double value;
    private String currency;

    public PriceJson(){}

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
