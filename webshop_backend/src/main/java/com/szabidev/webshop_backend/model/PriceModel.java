package com.szabidev.webshop_backend.model;

import javax.persistence.*;
import java.util.Currency;

@Entity
@Table(name = "PRICE")
public class PriceModel {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "value")
    private Double value;

    @Column(name = "currency")
    private String currency;

    @OneToOne (mappedBy = "oneTimePrice")
    private ProductModel productModel;

    public PriceModel() {
    }

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
