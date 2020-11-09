package com.szabidev.webshop_backend.controller.dto;

import java.util.Map;

public class DeliveryModeJson {
    private String code;
    private Map<String, String> name;

    public DeliveryModeJson(){
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Map<String, String> getName() {
        return name;
    }

    public void setName(Map<String, String> name) {
        this.name = name;
    }
}
