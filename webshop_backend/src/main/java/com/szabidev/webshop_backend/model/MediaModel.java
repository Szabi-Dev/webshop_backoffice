package com.szabidev.webshop_backend.model;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "MEDIA")
public class MediaModel {

    @Id
    @GeneratedValue
    private Long Id;

    @OneToMany(mappedBy = "fkMediaModel", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @MapKey(name = "locale")
    private Map<String, MediaLocalizedModel> localizations;

    @Column(name = "relativePath")
    private String relativePath;

    public MediaModel() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Map<String, MediaLocalizedModel> getLocalizations() {
        return localizations;
    }

    public void setLocalizations(Map<String, MediaLocalizedModel> localizations) {
        this.localizations = localizations;
    }

    public String getRelativePath() {
        return relativePath;
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }
}
