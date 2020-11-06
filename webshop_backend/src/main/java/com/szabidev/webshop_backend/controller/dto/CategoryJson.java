package com.szabidev.webshop_backend.controller.dto;

import java.util.Map;

public class CategoryJson {

    Map<String, String> name;

    public CategoryJson() {
    }

    public Map<String, String> getName() {
        return name;
    }

    public void setName(Map<String, String> name) {
        this.name = name;
    }
}
