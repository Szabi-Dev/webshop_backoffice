package com.szabidev.webshop_backend.model;

import javax.persistence.*;

@Entity
@Table(name = "MEDIA_LOCALIZED")
public class MediaLocalizedModel {

    @Id
    @GeneratedValue
    private String Id;

    @Column(name = "locale")
    private String locale;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    private MediaModel fkMediaModel;

    public MediaLocalizedModel() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MediaModel getFkMediaModel() {
        return fkMediaModel;
    }

    public void setFkMediaModel(MediaModel fkMediaModel) {
        this.fkMediaModel = fkMediaModel;
    }
}
