package com.szabidev.webshop_backend.facade.dto;

import org.springframework.hateoas.RepresentationModel;

public class ProductData extends RepresentationModel<ProductData> {

    private Long id;
    private String code;
    private String name;
    private String description;

    private PriceData oneTimePrice;

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

    public PriceData getOneTimePrice() {
        return oneTimePrice;
    }

    public void setOneTimePrice(PriceData oneTimePrice) {
        this.oneTimePrice = oneTimePrice;
    }
}
