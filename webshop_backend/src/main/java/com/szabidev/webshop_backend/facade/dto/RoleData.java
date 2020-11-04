package com.szabidev.webshop_backend.facade.dto;

import org.springframework.hateoas.RepresentationModel;

public class RoleData extends RepresentationModel<RoleData> {

    private Long id;
    private String name;

    public RoleData(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
