package com.szabidev.webshop_backend.controller.dto;

import java.util.Map;

public class ProductJson {
    private String code;
    private Map<String, String> name;
    private Map<String, String> description;
    private PriceJson oneTimePrice;

    public ProductJson() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Map<String, String> getName() {
        return name;
    }

    public void setName(Map<String, String> name) {
        this.name = name;
    }

    public Map<String, String> getDescription() {
        return description;
    }

    public void setDescription(Map<String, String> description) {
        this.description = description;
    }

    public PriceJson getOneTimePrice() {
        return oneTimePrice;
    }

    public void setOneTimePrice(PriceJson oneTimePrice) {
        this.oneTimePrice = oneTimePrice;
    }
}
