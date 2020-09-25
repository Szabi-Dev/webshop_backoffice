package com.szabidev.webshop_backend.facade.dto;

import org.springframework.hateoas.RepresentationModel;

public class PrivilegeData extends RepresentationModel<PrivilegeData> {

    private Long id;
    private String name;

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
}
