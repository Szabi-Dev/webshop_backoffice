package com.szabidev.webshop_backend.controller.dto;

import java.util.Map;

public class MediaJson {

    private String relativePath;
    private Map<String, String> name;
    private Map<String, String> description;

    public MediaJson(){}

    public String getRelativePath() {
        return relativePath;
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
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
}
