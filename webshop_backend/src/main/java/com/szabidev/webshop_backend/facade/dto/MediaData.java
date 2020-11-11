package com.szabidev.webshop_backend.facade.dto;

import org.springframework.hateoas.RepresentationModel;

public class MediaData extends RepresentationModel<MediaData> {

    private Long id;
    private String name;
    private String description;
    private String relativePath;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getRelativePath() {
        return relativePath;
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }
}
