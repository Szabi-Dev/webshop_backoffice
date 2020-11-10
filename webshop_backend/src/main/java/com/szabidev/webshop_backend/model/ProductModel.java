package com.szabidev.webshop_backend.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Map;

@Entity
@Table(name = "PRODUCT_TABLE")
public class ProductModel {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "code", unique = true)
    private String code;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "main_image_id", referencedColumnName = "id")
    private MediaModel mainImage;

    @OneToMany(mappedBy = "fkProduct", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @MapKey(name = "locale")
    Map<String, ProductLocalizedModel> localizations;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "price_id", referencedColumnName = "id")
    private PriceModel oneTimePrice;

    @ManyToMany
    @JoinTable(name = "product_categories",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    private Collection<CategoryModel> categories;

    @ManyToMany
    @JoinTable( name = "product_deliverymodes",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "deliverymode_id", referencedColumnName = "id"))
    private Collection<DeliveryModeModel> deliveryModes;

    public ProductModel() {
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

    public Map<String, ProductLocalizedModel> getLocalizations() {
        return localizations;
    }

    public void setLocalizations(Map<String, ProductLocalizedModel> localizations) {
        this.localizations = localizations;
    }

    public Collection<CategoryModel> getCategories() {
        return categories;
    }

    public void setCategories(Collection<CategoryModel> categories) {
        this.categories = categories;
    }

    public Collection<DeliveryModeModel> getDeliveryModes() {
        return deliveryModes;
    }

    public void setDeliveryModes(Collection<DeliveryModeModel> deliveryModes) {
        this.deliveryModes = deliveryModes;
    }

    public PriceModel getOneTimePrice() {
        return oneTimePrice;
    }

    public void setOneTimePrice(PriceModel oneTimePrice) {
        this.oneTimePrice = oneTimePrice;
    }
}
